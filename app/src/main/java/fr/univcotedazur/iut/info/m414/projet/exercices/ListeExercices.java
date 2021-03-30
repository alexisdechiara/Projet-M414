package fr.univcotedazur.iut.info.m414.projet.exercices;

import java.util.ArrayList;

public class ListeExercices {
    private static ArrayList<Exercice> listeExercices;
    private static final ListeExercices instance = new ListeExercices();

    public static ListeExercices getInstance() {
        return instance;
    }

    private ListeExercices() {
        listeExercices = new ArrayList<>();
    }

    public static int size() {
        return instance.getListeExercices().size();
    }

    public static Exercice get(int pos) {
        return instance.getListeExercices().get(pos);
    }

    public static void add(Exercice e) {
        instance.getListeExercices().add(e);
    }

    private ArrayList<Exercice> getListeExercices() {
        return listeExercices;
    }

}
