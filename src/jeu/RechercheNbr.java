package jeu;

import joueur.Joueur;

import java.util.Random;

public class RechercheNbr implements Jeu {
    private Joueur attaquant;
    private Joueur defenseur;
    private String combinaisonSecrete;
    private String nombreRecu;
    private String v;


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

    public String getCombinaisonSecrete() {
        return combinaisonSecrete;
    }


    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, 4);
        return v;
    }

    public void premiereProposition(){
        nombreRecu = this.generateur();
        System.out.println(nombreRecu);

    }


    public String generateurDemanderNbrReponse() {


        return null;
    }


}