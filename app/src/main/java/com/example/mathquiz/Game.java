package com.example.mathquiz;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<question> questions;
    private int correct;
    private int incorrect;
    private int totalQuestions;
    private int score;
    private question currentQuestion;

    public Game(){
        questions = new ArrayList<question>();
        this.correct = 0;
        this.incorrect = 0;
        this.score = 0;
        this.totalQuestions = 0;
        currentQuestion = new question(12);
    }

    public void makeNewQuestion(){
        currentQuestion = new question(totalQuestions * 3 + 5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int ans){
        boolean isCorrect;
        if (currentQuestion.getAnswer() == ans){
            correct++;
            isCorrect = true;
        }
        else {
            incorrect++;
            isCorrect = false;
        }

        score = (correct * 10) - (incorrect * 25);
        return isCorrect;
    }


    public List<question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<question> questions) {
        this.questions = questions;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
