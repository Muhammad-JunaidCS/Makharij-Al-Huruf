package com.example.makhrijal_hurf;

public class Question {
    private String letter;
    private String answer;
    private String marked;

    public Question(String letter, String answer, String marked) {
        this.letter = letter;
        this.answer = answer;
        this.marked = marked;
    }

    public String getLetter() {
        return letter;
    }

    public String getAnswer() {
        return answer;
    }

    public String getMarked() {
        return marked;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setMarked(String marked) {
        this.marked = marked;
    }
}

