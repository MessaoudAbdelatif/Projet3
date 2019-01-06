import jeu.Jeu;
import jeu.Mastermind;
import jeu.RechercheNbr;
import joueur.*;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private String selectionChoixJeu = "";
    private Jeu choixJeu;
    private Joueur joueur1;
    private Joueur joueur2;


    private void challenger() {
        joueur1 = new Humain();

        switch (selectionChoixJeu) {
            case "1":
                joueur2 = new IARechercheNbr();
            case "2":
                joueur2 = new IAMastermind();
        }

        Jeu jeu1 = choixJeu;
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


    private void defenseur() {
        switch (selectionChoixJeu) {
            case "1":
                joueur1 = new IARechercheNbr();
            case "2":
                joueur1 = new IAMastermind();
        }
        joueur2 = new Humain();

        Jeu jeu1 = choixJeu;
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


    private void duel() {
        joueur1 = new Humain();
        joueur2 = new Humain();
        Jeu jeu1 = choixJeu;
        Jeu jeu2 = choixJeu;
        switch (selectionChoixJeu) {
            case "1":
                jeu2 = new RechercheNbr();
                break;
            case "2":
                jeu2 = new Mastermind();
                break;
        }

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


    public void choixDuJeu() {

        System.out.println("Bienvenue au Projet3 OpenClassRoom!  \n 1/ Recherche Combinaison Secrete +/-. \n 2/ MasterMind. \n Veuillez Selectionner un jeu: ");
        this.selectionChoixJeu = sc.nextLine();
        if (selectionChoixJeu.equals("1") || selectionChoixJeu.equals("Recherche Combinaison Secrete +/-") || selectionChoixJeu.equals("Recherche Combinaison Secrete")) {
            choixJeu = new RechercheNbr();
            selectionChoixJeu = "1";
            choixDuMode();
        } else if (selectionChoixJeu.equals("2") || selectionChoixJeu.equals("MasterMind")) {
            choixJeu = new Mastermind();
            selectionChoixJeu = "2";
            choixDuMode();
        } else {
            System.out.println("Je ne trouve pas le jeu sélectionné!! \n De nouveau veuillez sélectionner le numéro associé au jeu.");
            this.choixDuJeu();
        }

    }

    private void choixDuMode() {
        System.out.println(" 1/ Challenger. \n 2/ Defenseur. \n 3/ Duel. \n Veuillez Inserez le numéro de mode de jeu désiré: ");
        int selectionChoixMode = sc.nextInt();
        switch (selectionChoixMode) {
            case 1:
                this.challenger();
                break;
            case 2:
                this.defenseur();
                break;
            case 3:
                this.duel();
                break;

            default:
                System.out.println("De Nouveau, Veuillez inserez un numéro de mode valide!");
                choixDuMode();
                break;
        }
    }

}