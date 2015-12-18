package com.epam.association.model.util;

import com.epam.association.model.entity.GamePlate;

public class AnswerChecker {
    public AnswerChecker() {
    }

    public boolean checkAnswer(String userAnswer, GamePlate plate) {
        boolean matches = false;
        String hiddenWord = plate.getHiddenWord().toUpperCase();
        String[] strings = userAnswer.split(" ");
        for (String answer: strings) {
            matches = hiddenWord.matches(answer.toUpperCase());
            if (matches) break;
        }
        return matches;
    }
}
