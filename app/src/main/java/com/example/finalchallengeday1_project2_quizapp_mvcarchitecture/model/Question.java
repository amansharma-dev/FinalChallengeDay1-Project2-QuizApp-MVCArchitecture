package com.example.finalchallengeday1_project2_quizapp_mvcarchitecture.model;

public class Question {
    private int questionText;
    private boolean isAnswerTrue;

    public Question() {
    }

    public Question(int questionText, boolean isAnswerTrue) {
        this.questionText = questionText;
        this.isAnswerTrue = isAnswerTrue;
    }

    public int getQuestionText() {
        return questionText;
    }

    public void setQuestionText(int questionText) {
        this.questionText = questionText;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        isAnswerTrue = answerTrue;
    }
}
