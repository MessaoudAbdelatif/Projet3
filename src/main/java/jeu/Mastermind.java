package jeu;

import joueur.Joueur;

public class Mastermind implements Jeu {
    private Joueur attaquant;
    private Joueur defenseur;
    private String combinaisonSecrete;
    private String nombreRecu;
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
        comparaisonLogique(nombreRecu, combinaisonSecrete);
        attaquant.donnerUnIndice(indice);
    }

    public String comparaisonLogique(String nombreRecu, String combinaisonSecrete) {
        int nbPresent = 0;
        int nbBienPlace = 0;

        boolean[] tagBienPlace = new boolean[nombreRecu.length()];


        for (int i = 0; i < combinaisonSecrete.length(); i++) {
            if (nombreRecu.charAt(i) == combinaisonSecrete.charAt(i)) {
                nbBienPlace++;
                tagBienPlace[i] = true;
            } else {
                tagBienPlace[i] = false;
            }
        }

        for (int i = 0; i < combinaisonSecrete.length(); i++) {
            if (nombreRecu.charAt(i) != combinaisonSecrete.charAt(i)) {
                int j = 0;
                boolean tagPresent = false;
                while (!tagPresent && j < combinaisonSecrete.length()) {
                    if (!tagBienPlace[j] && (nombreRecu.charAt(j) == combinaisonSecrete.charAt(i))) {
                        nbPresent++;
                        tagPresent = true;
                    }
                    j++;
                }
            }
        }
        indice = (nbBienPlace + " Bien Placé" + " " + nbPresent + " Présent");


        return indice;
    }


    @Override
    public boolean isFini() {
        return combinaisonSecrete.equals(nombreRecu);


    }

    @Override
    public void printCombinaison() {
        System.out.println("La combinaison secrète: " + combinaisonSecrete);

    }
}