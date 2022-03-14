package com.rachelquijano.quizapp;

import java.util.ArrayList;

public class Constants {


    public static ArrayList<QuestionModel> getQuestions(){
        ArrayList<QuestionModel> questions = new ArrayList<>();
        String question = "What is this called?";
        QuestionModel que1 = new QuestionModel(1, question, R.drawable.question_mitochondria, "Ribosome",
                "Mitochondria", "Nucleus", "Cytoplasm", 2);
        QuestionModel que2 = new QuestionModel(2, question, R.drawable.question_chloroplast, "Mitochondria", "Cell Wall",
                "Chlorophyll", "Chloroplast", 4);
        questions.add(que1);
        questions.add(que2);
        return questions;
    }
}
