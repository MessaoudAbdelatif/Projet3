package jeu;

import joueur.Joueur;

public class RechercheNbr implements Jeu{
    private Joueur attaquant;
    private Joueur defenseur;


    @Override
    public void setJoueur(Joueur attaquant, Joueur defenseur) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;
    }

    @Override
    public void jouerTour() {

    }

    @Override
    public boolean isFini() {
        return false;
    }
}
