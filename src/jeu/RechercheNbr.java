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


        char[] tab = new char[nombreRecu.length()];
        for (int i = 0; i < nombreRecu.length(); i++) {
            if (nombreRecu.charAt(i) == combinaisonSecrete.charAt(i))
                tab[i] = '=';
            if (nombreRecu.charAt(i) < combinaisonSecrete.charAt(i))
                tab[i] = '-';
            if (nombreRecu.charAt(i) > combinaisonSecrete.charAt(i))
                tab[i] = '+';
        }
        attaquant.donnerUnIndice(new String(tab));
    }


    @Override
    public boolean isFini() {
        if (combinaisonSecrete.equals(nombreRecu)) {
            return true;
        }

        return false;
    }


    public void premierTour() {
        combinaisonSecrete = defenseur.demanderNbrAleatoire();

    }

}


