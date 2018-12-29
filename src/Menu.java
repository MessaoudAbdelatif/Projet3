import jeu.Jeu;
import jeu.RechercheNbr;
import joueur.Humain;
import joueur.IA;
import joueur.Joueur;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    private int selectionChoixJeu = 0;
    private Joueur joueur1;
    private Joueur joueur2;


    private void challenger(int selectionChoixJeu) {
        joueur1 = new Humain();
        joueur2 = new IA();

        switch (selectionChoixJeu) {

            case 1:
                rechercheNbrModeChallenger();
                break;
            case 2:
                break;
        }
    }


    private void defenseur(int selectionChoixJeu) {
        joueur1 = new IA();
        joueur2 = new Humain();

        switch (selectionChoixJeu) {
            case 1:
                rechercheNbrModeDefenseur();
                break;
            case 2:
                break;
        }
    }

    private void duel(int selectionChoixJeu) {
        joueur1 = new Humain();
        joueur2 = new Humain();

        switch (selectionChoixJeu) {
            case 1:
                rechercheNbrModeDuel();
                break;
            case 2:
                break;
        }
    }


    private void rechercheNbrModeChallenger() {
        Jeu jeu1 = new RechercheNbr();
        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();

        int compteurTentative = 0; // compteurTentative: is loop counter
        while (!jeu1.isFini()) {
            compteurTentative++;
            jeu1.jouerTour();

        }
        System.out.print("Bravo Combinaison secrete trouvée: ");
        jeu1.printCombinaison();

        if (compteurTentative > 1) {
            System.out.println("  Le jeu est fini en  " + compteurTentative + " tentatives");
        } else {
            System.out.println("  Le jeu est fini en  " + compteurTentative + " tentative");
        }

    }

    private void rechercheNbrModeDefenseur() {
        Jeu jeu1 = new RechercheNbr();
        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();
        int compteurTentative = 0; // compteurTentative: is loop counter
        while (!jeu1.isFini()) {
            compteurTentative++;
            jeu1.jouerTour();

        }
        System.out.print("Bravo Combinaison secrete trouvée: ");
        jeu1.printCombinaison();
        if (compteurTentative > 1) {
            System.out.println("  Le jeu est fini en  " + compteurTentative + " tentatives");
        } else {
            System.out.println("  Le jeu est fini en  " + compteurTentative + " tentative");
        }
    }

    private void rechercheNbrModeDuel() {

        Jeu jeu1 = new RechercheNbr();
        Jeu jeu2 = new RechercheNbr();

        jeu1.setJoueur(joueur1, joueur2);
        jeu2.setJoueur(joueur1, joueur2);
        System.out.println("JOUEUR 1");
        jeu2.premierTour();
        System.out.println("JOUEUR 2");
        jeu1.premierTour();


        int compteurTentativeJoueur1 = 0; // compteurTentativeJoueur1: first  player tentatives counter
        int compteurTentativeJoueur2 = 0; // compteurTentativeJoueur2: second player tentatives counter
        boolean alternateurJoueur = false;

        while (!jeu1.isFini() && !jeu2.isFini()) {
            if (!jeu1.isFini() && !jeu2.isFini() && alternateurJoueur == false) {
                compteurTentativeJoueur1++;
                System.out.println("JOUEUR 1");
                jeu1.jouerTour();


                if (jeu1.isFini()) {
                    System.out.print("Bravo Joueur 1 Win!! Combinaison secrete trouvée: ");
                    jeu1.printCombinaison();
                    if (compteurTentativeJoueur1 > 1) {
                        System.out.println("  Le jeu est fini en  " + compteurTentativeJoueur1 + " tentatives");
                    } else {
                        System.out.println("  Le jeu est fini en  " + compteurTentativeJoueur1 + " tentative");
                    }
                }

            }
            alternateurJoueur = true;

            if (!jeu2.isFini() && !jeu1.isFini() && alternateurJoueur == true) {
                compteurTentativeJoueur2++;
                System.out.println("JOUEUR 2");
                jeu2.jouerTour();


                if (jeu2.isFini()) {
                    System.out.print("Bravo Joueur 2 Win!! Combinaison secrete trouvée: ");
                    jeu2.printCombinaison();

                    if (compteurTentativeJoueur2 > 1) {
                        System.out.println("  Le jeu est fini en  " + compteurTentativeJoueur2 + " tentatives");
                    } else {
                        System.out.println("  Le jeu est fini en  " + compteurTentativeJoueur2 + " tentative");
                    }
                }

            }
            alternateurJoueur = false;
        }
    }

    private void choixDuMode(int selectionChoixJeu) {
        System.out.println(" 1/ challenger. \n 2/ Defenseur. \n 3/ Duel. \n Veuillez Séléctionner un Mode de Jeu: ");
        int selectionChoixMode = sc.nextInt();
        switch (selectionChoixMode) {
            case 1:
                this.challenger(selectionChoixJeu);
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