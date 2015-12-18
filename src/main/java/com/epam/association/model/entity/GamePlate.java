package com.epam.association.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "GAME")
public class GamePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private int id;

    @Basic
    @Column(name = "HIDDEN_WORD")
    private String hiddenWord;

    @Basic
    @Column(name = "URL1")
    private String firstPictureUrl;

    @Basic
    @Column(name = "URL2")
    private String secondPictureUrl;

    @Basic
    @Column(name = "URL3")
    private String thirdPictureUrl;

    @Basic
    @Column(name = "URL4")
    private String forthPictureUrl;

    @OneToOne
    @JoinColumn(name = "RESULT")
    private Result result;

    public GamePlate() {
    }

    public GamePlate(String hiddenWord, String firstPictureUrl, String secondPictureUrl, String thirdPictureUrl, String forthPictureUrl) {
        this.hiddenWord = hiddenWord;
        this.firstPictureUrl = firstPictureUrl;
        this.secondPictureUrl = secondPictureUrl;
        this.thirdPictureUrl = thirdPictureUrl;
        this.forthPictureUrl = forthPictureUrl;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getFirstPictureUrl() {
        return firstPictureUrl;
    }

    public void setFirstPictureUrl(String firstPictureUrl) {
        this.firstPictureUrl = firstPictureUrl;
    }

    public String getSecondPictureUrl() {
        return secondPictureUrl;
    }

    public void setSecondPictureUrl(String secondPictureUrl) {
        this.secondPictureUrl = secondPictureUrl;
    }

    public String getThirdPictureUrl() {
        return thirdPictureUrl;
    }

    public void setThirdPictureUrl(String thirdPictureUrl) {
        this.thirdPictureUrl = thirdPictureUrl;
    }

    public String getForthPictureUrl() {
        return forthPictureUrl;
    }

    public void setForthPictureUrl(String forthPictureUrl) {
        this.forthPictureUrl = forthPictureUrl;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamePlate gamePlate = (GamePlate) o;

        if (!hiddenWord.equals(gamePlate.hiddenWord)) return false;
        if (!firstPictureUrl.equals(gamePlate.firstPictureUrl)) return false;
        if (!secondPictureUrl.equals(gamePlate.secondPictureUrl)) return false;
        if (!thirdPictureUrl.equals(gamePlate.thirdPictureUrl)) return false;
        return forthPictureUrl.equals(gamePlate.forthPictureUrl);

    }

    @Override
    public int hashCode() {
        int result = hiddenWord.hashCode();
        result = 31 * result + firstPictureUrl.hashCode();
        result = 31 * result + secondPictureUrl.hashCode();
        result = 31 * result + thirdPictureUrl.hashCode();
        result = 31 * result + forthPictureUrl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GamePlate{" +
                "id=" + id +
                ", hiddenWord='" + hiddenWord + '\'' +
                ", firstPictureUrl='" + firstPictureUrl + '\'' +
                ", secondPictureUrl='" + secondPictureUrl + '\'' +
                ", thirdPictureUrl='" + thirdPictureUrl + '\'' +
                ", forthPictureUrl='" + forthPictureUrl + '\'' +
                '}';
    }
}
