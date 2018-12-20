import jeu.Jeu;
import jeu.RechercheNbr;
import joueur.Humain;
import joueur.IA;
import joueur.Joueur;


public class Main {

    public static void main(String[] args) {


/*
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0,4);
        System.out.println(v);
*/
/** MODE Duel */
        Joueur joueur1 = new Humain();
        Joueur joueur2 = new Humain();
        Jeu jeu1 = new RechercheNbr();
        Jeu jeu2 = new RechercheNbr();

        jeu1.setJoueur(joueur1, joueur2);
        jeu2.setJoueur(joueur1, joueur2);
        System.out.println("JOUEUR 1");
        jeu2.premierTour();
        System.out.println("JOUEUR 2");
        jeu1.premierTour();


        int r1 = 0; // r1: loop counter
        int r2 = 0; // r2: second player loop counter
        boolean alternateurJoueur = false;

        while (!jeu1.isFini() || !jeu2.isFini()) {
            while (!jeu1.isFini() && alternateurJoueur == false) {
                r1++;
                System.out.println("JOUEUR 1");
                jeu1.jouerTour();


                if (jeu1.isFini())
                    System.out.println("Bravo Combinaison secrete trouvée: " + ((RechercheNbr) jeu1).getCombinaisonSecrete() + "  Le jeu est fini en  " + r1 + " tentative(s)");
                break;
            }
            alternateurJoueur = true;

            while (!jeu2.isFini() && alternateurJoueur == true) {
                r2++;
                System.out.println("JOUEUR 2");
                jeu2.jouerTour();


                if (jeu2.isFini())
                    System.out.println("Bravo Combinaison secrete trouvée: " + ((RechercheNbr) jeu2).getCombinaisonSecrete() + "  Le jeu est fini en  " + r2 + " tentative(s)");
                break;
            }
            alternateurJoueur = false;
        }
        if (r1 > r2) {
            System.out.println("Game Over !! le joueur 2 à gagné");
        } else if (r1 < r2) {
            System.out.println("Game Over !! le joueur 1 à gagné");
        } else {
            System.out.println("Game Over !! Match nul");
        }

/** MODE Challenger : */
/*
        Joueur joueur1 = new Humain();
        Joueur joueur2 = new IA();
        Jeu jeu1 = new RechercheNbr();

        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();
        int r1 = 0; // r1: is loop counter
        while (!jeu1.isFini()) {
            r1++;
            jeu1.jouerTour();

        }
        System.out.println("Bravo Combinaison secrete trouvée: " + ((RechercheNbr) jeu1).combinaisonSecrete + "  Le jeu est fini en  " + r1 + " tentative(s)");
*/

    }

}
