CREATE TABLE game
(
    GAME_ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    HIDDEN_WORD CHAR NOT NULL,
    URL1 CHAR NOT NULL,
    URL2 CHAR NOT NULL,
    URL3 CHAR NOT NULL,
    URL4 CHAR NOT NULL,
    result INT NOT NULL
);
ALTER TABLE game ADD CONSTRAINT unique_GAME_ID UNIQUE (GAME_ID);

CREATE TABLE PUBLIC.result
(
    RESULT_ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    HINT_COUNTER INT NOT NULL,
    SCORE DOUBLE NOT NULL
);
ALTER TABLE PUBLIC.result ADD CONSTRAINT unique_RESULT_ID UNIQUE (RESULT_ID);

INSERT INTO RESULT VALUES (DEFAULT, 0, 0);
INSERT INTO RESULT VALUES (DEFAULT, 0, 1);
INSERT INTO RESULT VALUES (DEFAULT, 0, 2);
INSERT INTO RESULT VALUES (DEFAULT, 0, 0);
INSERT INTO RESULT VALUES (DEFAULT, 0, 3);

INSERT INTO GAME VALUES (DEFAULT, 'aaaaa', 'aaaaa', 'aaaaa', 'aaaaa', 'aaaaa', 1);
INSERT INTO GAME VALUES (DEFAULT, 'bbbbb', 'bbbbb', 'bbbbb', 'bbbbb', 'bbbbb', 2);
INSERT INTO GAME VALUES (DEFAULT, 'ccccc', 'ccccc', 'ccccc', 'ccccc', 'ccccc', 3);
INSERT INTO GAME VALUES (DEFAULT, 'ddddd', 'ddddd', 'ddddd', 'ddddd', 'ddddd', 4);
INSERT INTO GAME VALUES (DEFAULT, 'eeeee', 'eeeee', 'eeeee', 'eeeee', 'eeeee', 5);

UPDATE RESULT SET HINT_COUNTER=0 WHERE RESULT_ID=1;
UPDATE RESULT SET HINT_COUNTER=0 WHERE RESULT_ID=2;
UPDATE RESULT SET HINT_COUNTER=0 WHERE RESULT_ID=3;
UPDATE RESULT SET HINT_COUNTER=0 WHERE RESULT_ID=4;
UPDATE RESULT SET HINT_COUNTER=0 WHERE RESULT_ID=5;