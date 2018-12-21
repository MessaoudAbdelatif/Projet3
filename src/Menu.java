import jeu.Jeu;
import jeu.RechercheNbr;
import joueur.Humain;
import joueur.IA;
import joueur.Joueur;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);


    public void choixDuJeu() {
        int choixJeu = 0;
        System.out.println(
                "Bienvenue au Projet3 OpenClassRoom! /n Veuillez Selectioner un Jeu: /n 1/ Recherche +/- /n 2/ MasterMind"
        );
        choixJeu = sc.nextInt();
        switch (choixJeu){
            case 1:
               // choixDuMode(RechercheNbr);
                break;
                
            default:
                break;


        }

    }

    private void choixDuMode(Jeu jeu) {



    }

    private void challangeur(int choixJeu) {


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
        System.out.printf("Bravo Combinaison secrete trouvée: ");
        jeu1.printCombinaison();
        System.out.println("  Le jeu est fini en  " + r1 + " tentative(s)");


    }

    private void defenseur(int choixJeu) {


        Joueur joueur1 = new IA();
        Joueur joueur2 = new Humain();
        Jeu jeu1 = new RechercheNbr();
        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();
        int r1 = 0; // r1: is loop counter
        while (!jeu1.isFini()) {
            r1++;
            jeu1.jouerTour();

        }
        System.out.printf("Bravo Combinaison secrete trouvée: ");
        jeu1.printCombinaison();
        System.out.println("  Le jeu est fini en  " + r1 + " tentative(s)");


    }

    private void duel(int choixJeu) {

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
            if (!jeu1.isFini() && alternateurJoueur == false) {
                r1++;
                System.out.println("JOUEUR 1");
                jeu1.jouerTour();


                if (jeu1.isFini()) {
                    System.out.printf("Bravo Combinaison secrete trouvée: ");
                    jeu1.printCombinaison();
                    System.out.println("  Le jeu est fini en  " + r1 + " tentative(s)");
                }

            }
            alternateurJoueur = true;

            if (!jeu2.isFini() && alternateurJoueur == true) {
                r2++;
                System.out.println("JOUEUR 2");
                jeu2.jouerTour();


                if (jeu2.isFini()){
                    System.out.printf("Bravo Combinaison secrete trouvée: ");
                jeu2.printCombinaison();
                System.out.println("  Le jeu est fini en  " + r2 + " tentative(s)");
                }

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


    }


}
