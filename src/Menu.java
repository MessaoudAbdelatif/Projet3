import jeu.Jeu;
import jeu.RechercheNbr;
import joueur.Humain;
import joueur.IA;
import joueur.Joueur;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    private int selectionChoixJeu = 0;



    private void challangeur(int selectionChoixJeu) {
        switch (selectionChoixJeu) {
            case 1:


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
                break;
            case 2:
                break;
        }
    }


    private void defenseur(int selectionChoixJeu) {
        switch (selectionChoixJeu) {
            case 1:

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
                break;
            case 2:
                break;
        }
    }

    private void duel(int selectionChoixJeu) {

        switch (selectionChoixJeu) {
            case 1:

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


                        if (jeu2.isFini()) {
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
                break;
            case 2:
                break;
        }

    }

    private void choixDuMode(int selectionChoixJeu) {
        System.out.println(" 1/ Challangeur. \n 2/ Defenseur. \n 3/ Duel. \n Veuillez Séléctionner un Mode de Jeu: ");
        int selectionChoixMode = sc.nextInt();
        switch (selectionChoixMode) {
            case 1:
                this.challangeur(selectionChoixJeu);
                break;
            case 2:
                this.defenseur(selectionChoixJeu);
                break;
            case 3:
                this.duel(selectionChoixJeu);
                break;

            default:
                break;
        }
    }

    public void choixDuJeu() {

        System.out.println("Bienvenue au Projet3 OpenClassRoom!  \n 1/ Recherche Combinaison Secrete +/-. \n 2/ MasterMind. \n Veuillez Selectionner un Jeu: ");
        this.selectionChoixJeu = sc.nextInt();
        switch (selectionChoixJeu) {
            case 1:
                this.choixDuMode(selectionChoixJeu);
                break;
//          case 2:
//                this.choixDuMode(MasterMind);
            default:
                break;
        }

    }

}