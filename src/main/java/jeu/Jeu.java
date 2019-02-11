package jeu;

import joueur.Joueur;

public interface Jeu {
    void setJoueur(Joueur attaquant, Joueur defenseur);

    void premierTour();

    void jouerTour();

    boolean isFini();

    void printCombinaison();

}