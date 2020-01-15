package com.example.mathquiz;

import java.util.Random;

public class question {

    private int firstNum;
    private int secondNum;
    private int answer;

    //four answers to choose from
    private int[] answerArray;
    private int answerPosition;

    private int upperLimit;
    private String questionPhrase;

    //constructor
    public question(int upperLimit){
        this.upperLimit = upperLimit;
        Random rand = new Random();

        this.firstNum = rand.nextInt(upperLimit);
        this.secondNum = rand.nextInt(upperLimit);

        this.answer = firstNum + secondNum;
        this.questionPhrase = firstNum + " + " + secondNum + " = ";

        this.answerPosition = rand.nextInt(4);

        this.answerArray = new int[4];
        this.answerArray[0] = answer + 1;
        this.answerArray[1] = answer - 3;
        this.answerArray[2] = answer - 1;
        this.answerArray[3] = answer + 2;

        this.answerArray = shuffleArray(this.answerArray);

        this.answerArray[answerPosition] = answer;

    }

    private int[] shuffleArray(int[] array){
        int index,temp;
        Random randNum = new Random();

        for(int i = array.length - 1; i > 0; i--){
            index = randNum.nextInt(i + 1);
            temp = array[index];

            array[index] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
