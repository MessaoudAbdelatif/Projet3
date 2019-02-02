package jeu;

import joueur.Joueur;

public class RechercheNbr implements Jeu {
    private Joueur attaquant;
    private Joueur defenseur;
    private String combinaisonSecrete;
    private String nombreRecu;


    @Override
    public void setJoueur(Joueur attaquant, Joueur defenseur) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;


    }

    @Override
    public void jouerTour() {

        nombreRecu = attaquant.demanderNbrReponse();
        comparaisonLogique(nombreRecu, combinaisonSecrete);

/*
        char[] tab = new char[nombreRecu.length()];
        for (int i = 0; i < nombreRecu.length(); i++) {
            if (this.nombreRecu.charAt(i) == this.combinaisonSecrete.charAt(i))
                tab[i] = '=';
            if (this.nombreRecu.charAt(i) > this.combinaisonSecrete.charAt(i))
                tab[i] = '-';
            if (this.nombreRecu.charAt(i) < this.combinaisonSecrete.charAt(i))
                tab[i] = '+';
        }
        attaquant.donnerUnIndice(new String(tab));*/
    }

    private void comparaisonLogique(String nombreRecu, String combinaisonSecrete) {

        char[] tab = new char[nombreRecu.length()];
        for (int i = 0; i < nombreRecu.length(); i++) {
            if (this.nombreRecu.charAt(i) == this.combinaisonSecrete.charAt(i))
                tab[i] = '=';
            if (this.nombreRecu.charAt(i) > this.combinaisonSecrete.charAt(i))
                tab[i] = '-';
            if (this.nombreRecu.charAt(i) < this.combinaisonSecrete.charAt(i))
                tab[i] = '+';
        }
        attaquant.donnerUnIndice(new String(tab));

    }

    @Override
    public boolean isFini() {


        if (this.combinaisonSecrete.equals(nombreRecu)) {

            return true;
        }

        return false;
    }


    public void premierTour() {

        combinaisonSecrete = defenseur.demanderNbrAleatoire();

    }


    @Override
    public void printCombinaison() {
        System.out.println("La combinaison secrète: " + combinaisonSecrete);

    }
}