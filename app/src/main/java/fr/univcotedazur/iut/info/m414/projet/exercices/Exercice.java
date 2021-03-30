package fr.univcotedazur.iut.info.m414.projet.exercices;

import java.util.ArrayList;

public class Exercice {
    private String titre;
    private boolean sendSMS;
    private ArrayList<String> questions;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isSendSMS() {
        return sendSMS;
    }

    public void setSendSMS(boolean sendSMS) {
        this.sendSMS = sendSMS;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public String getQuestion(int pos) {
        return questions.get(pos);
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public Exercice(String t, boolean SMS, ArrayList<String> q) {
        titre = t;
        sendSMS = SMS;
        questions = q;
    }

}
