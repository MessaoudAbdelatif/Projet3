package jeu;

import joueur.Joueur;

public class Mastermind implements Jeu {
    private Joueur attaquant;
    private Joueur defenseur;
    private String combinaisonSecrete;
    private String nombreRecu;
    private int nbPresent = 0;
    private int nbBienPlace = 0;
    private String indice = ("");

    @Override
    public void setJoueur(Joueur attaquant, Joueur defenseur) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;


    }

    @Override
    public void premierTour() {
        combinaisonSecrete = defenseur.demanderNbrAleatoire();

    }

    @Override
    public void jouerTour() {


        nombreRecu = attaquant.demanderNbrReponse();
        nbPresent = 0;
        nbBienPlace = 0;


        for (int i = 0; i < nombreRecu.length(); i++) {
            if (nombreRecu.charAt(i) == combinaisonSecrete.charAt(i))
                nbBienPlace++;
            else {
                for (int j = 0; j < combinaisonSecrete.length(); j++) {
                    if (nombreRecu.charAt(i) == combinaisonSecrete.charAt(j)) {
                        nbPresent++;

                    }
                }
            }
        }
        indice = (nbBienPlace + " Bien Placé" + " " + nbPresent + " Présent");

        attaquant.donnerUnIndice(indice);

    }


    @Override
    public boolean isFini() {


        if (combinaisonSecrete.equals(nombreRecu)) {

            return true;
        }


        return false;
    }

    @Override
    public void printCombinaison() {
        System.out.println(combinaisonSecrete);

    }
}
