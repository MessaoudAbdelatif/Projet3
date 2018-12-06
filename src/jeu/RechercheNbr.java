package jeu;


import joueur.Joueur;

public class RechercheNbr implements Jeu {
    private Joueur attaquant;
    private Joueur defenseur;


    @Override
    public void setJoueur(Joueur attaquant, Joueur defenseur) {
        this.attaquant = attaquant;
        this.defenseur = defenseur;
    }

    @Override
    public void jouerTour() {
        String nombreRecu = attaquant.demanderNbrReponse();
        String nombreReponse = defenseur.demanderNbrAleatoire();


        char[] tab = new char[nombreRecu.length()];
        for (int i = 0; i < nombreRecu.length(); i++) {
            if (nombreRecu.charAt(i) == nombreReponse.charAt(i))
                tab[i] = '=';
            if (nombreRecu.charAt(i) < nombreReponse.charAt(i))
                tab[i] = '-';
            if (nombreRecu.charAt(i) > nombreReponse.charAt(i))
                tab[i] = '+';
        }
        attaquant.donnerUnIndice(new String(tab));

    }


    @Override
    public boolean isFini() {
        return false;
    }
}
