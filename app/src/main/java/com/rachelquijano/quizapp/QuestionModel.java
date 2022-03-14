package com.rachelquijano.quizapp;

public class QuestionModel {

    private int id;
    private String question;
    private int image;
    private String option1, option2, option3, option4;
    private int correctOption;

    public QuestionModel(int id, String question, int image, String option1, String option2, String option3, String option4, int correctOption){
        this.id = id;
        this.question = question;
        this.image = image;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctOption = correctOption;

    }

    public String getQuestion() {
        return question;
    }

    public int getImage() {
        return image;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}
