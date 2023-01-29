package com.example.quizinggris;

public class QuizList {
    private final String soal,pil1,pil2,pil3,pil4,jawaban;

    private int nmrquiz;

    public String getSoal() {
        return soal;
    }

    public String getPil1() {
        return pil1;
    }

    public String getPil2() {
        return pil2;
    }

    public String getPil3() {
        return pil3;
    }

    public String getPil4() {
        return pil4;
    }

    public String getJawaban() {
        return jawaban;
    }

    public int getNmrquiz() {
        return nmrquiz;
    }

    public void setNmrquiz(int nmrquiz) {
        this.nmrquiz = nmrquiz;
    }

    public QuizList(String soal, String pil1, String pil2, String pil3, String pil4, String jawaban) {
        this.soal = soal;
        this.pil1 = pil1;
        this.pil2 = pil2;
        this.pil3 = pil3;
        this.pil4 = pil4;
        this.jawaban = jawaban;
        this.nmrquiz = 0;
    }
}