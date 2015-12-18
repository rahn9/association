package com.epam.association.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESULT")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESULT_ID")
    private int id;

    @Basic
    @Column(name = "HINT_COUNTER")
    private int hintCounter;

    @Basic
    @Column(name = "SCORE")
    private double score;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHintCounter() {
        return hintCounter;
    }

    public void setHintCounter(int hintCounter) {
        this.hintCounter = hintCounter;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double calculateScore() {
        this.score = 1 - 0.25 * hintCounter;
        return score;
    }
}