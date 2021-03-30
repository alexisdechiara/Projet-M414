package fr.univcotedazur.iut.info.m414.projet.exercices;

import java.util.ArrayList;

public class Exercice {
    private String titre;
    private boolean sendSMS;
    private ArrayList<String> questions;

    public Exercice(String t, boolean SMS, ArrayList<String> q) {
        titre = t;
        sendSMS = SMS;
        questions = q;
    }

}
