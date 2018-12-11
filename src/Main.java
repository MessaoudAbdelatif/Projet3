import jeu.Jeu;
import jeu.RechercheNbr;
import joueur.Humain;
import joueur.Joueur;

import java.util.Random;

public class Main {

    public static void main(String[] args) {



        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0,4);
        System.out.println(v);









        Joueur joueur1 = new Humain();
        Joueur joueur2 = new Humain();
        Jeu jeu1 = new RechercheNbr();

        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();

        while (!jeu1.isFini()){
            jeu1.jouerTour();
        }
        System.out.println("Bravo Combinaison secrete trouvé ! Le jeu est fini");





    }

}
