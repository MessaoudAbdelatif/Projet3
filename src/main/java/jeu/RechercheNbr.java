package jeu;

import joueur.Joueur;

import static joueur.PropertiesFile.getnbTentativesPossibleRechercheplusoumoins;

public class RechercheNbr implements Jeu {
    private Joueur attaquant;
    private Joueur defenseur;
    private String combinaisonSecrete;
    private String nombreRecu;
    private int nbTentativesPossibleRechercheplusoumoins= getnbTentativesPossibleRechercheplusoumoins();


    @Override
    public void setJoueur(Joueur attaquant, Joueur defenseur) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;


    }

    @Override
    public void jouerTour() {


        nombreRecu = attaquant.demanderNbrReponse();


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