import jeu.Jeu;
import jeu.Mastermind;
import jeu.RechercheNbr;
import joueur.*;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private String selectionChoixJeu = "";
    private Jeu choixJeu;
    private Joueur joueur1;
    private Joueur joueur2;
    private int nbTentativesPossibleRechercheplusoumoins = PropertiesFile.getnbTentativesPossibleRechercheplusoumoins();
    private int nbTentativesPossibleMastermind = PropertiesFile.getnbTentativesPossibleMastermind();


    private int nbTentativeLimite() {
        int maxTentatives = 0;
        switch (selectionChoixJeu) {

            case "1":
                maxTentatives = nbTentativesPossibleRechercheplusoumoins;
                break;
            case "2":
                maxTentatives = nbTentativesPossibleMastermind;
                break;

        }
        return maxTentatives;

    }

    private void challenger() {
        joueur1 = new Humain();

        switch (selectionChoixJeu) {
            case "1":
                joueur2 = new IARechercheNbr();
                break;
            case "2":
                joueur2 = new IAMastermind();
                break;
        }

        Jeu jeu1 = choixJeu;
        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();

        int compteurTentative = 0; // compteurTentative: is loop counter
        while (!jeu1.isFini() && compteurTentative < nbTentativeLimite()) {
            compteurTentative++;
            jeu1.jouerTour();


        }
        if (!jeu1.isFini() && compteurTentative == nbTentativeLimite()) {
            System.out.println("\nGAME OVER \nNombre de tentatives maximales atteind");
        } else {
            System.out.println("\nBravo");
        }
        jeu1.printCombinaison();

        if (compteurTentative > 1) {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentatives");
        } else {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentative");
        }

    }


    private void defenseur() {
        switch (selectionChoixJeu) {
            case "1":
                joueur1 = new IARechercheNbr();
                break;
            case "2":
                joueur1 = new IAMastermind();
                break;
        }
        joueur2 = new Humain();

        Jeu jeu1 = choixJeu;
        jeu1.setJoueur(joueur1, joueur2);
        jeu1.premierTour();

        int compteurTentative = 0; // compteurTentative: is loop counter
        while (!jeu1.isFini() && compteurTentative < nbTentativeLimite()) {
            compteurTentative++;
            jeu1.jouerTour();

        }
        if (!jeu1.isFini() && compteurTentative == nbTentativeLimite()) {
            System.out.println("\nGAME OVER \nNombre de tentatives maximales atteind");
        } else {
            System.out.println("\nBravo");
        }
        jeu1.printCombinaison();
        if (compteurTentative > 1) {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentatives");
        } else {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentative");
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


        int compteurTentative = 0; // compteurTentative

        boolean alternateurJoueur = false;

        while (!jeu1.isFini() && !jeu2.isFini() && compteurTentative < nbTentativeLimite()) {
            if (!jeu1.isFini() && !jeu2.isFini() && !alternateurJoueur) {
                compteurTentative++;
                System.out.println("JOUEUR 1");
                jeu1.jouerTour();


                if (jeu1.isFini()) {
                    System.out.print("Bravo Joueur 1 Win!!");
                    jeu1.printCombinaison();
                    if (compteurTentative > 1) {
                        System.out.println("Le jeu est fini en  " + compteurTentative + " tentatives");
                    } else {
                        System.out.println("Le jeu est fini en  " + compteurTentative + " tentative");
                    }
                }

            }
            alternateurJoueur = true;

            if (!jeu2.isFini() && !jeu1.isFini() && alternateurJoueur) {

                System.out.println("JOUEUR 2");
                jeu2.jouerTour();


                if (jeu2.isFini()) {
                    System.out.print("Bravo Joueur 2 Win!!");
                    jeu2.printCombinaison();

                    if (compteurTentative > 1) {
                        System.out.println("Le jeu est fini en  " + compteurTentative + " tentatives");
                    } else {
                        System.out.println("Le jeu est fini en  " + compteurTentative + " tentative");
                    }
                }

            }
            alternateurJoueur = false;
            if (!jeu1.isFini() && !jeu2.isFini() && compteurTentative == nbTentativeLimite()) {
                System.out.println("\nGAME OVER \nNombre de tentatives maximales atteind");
                System.out.println("Joueur 1: Fallait trouver :");
                jeu1.printCombinaison();
                System.out.println("Joueur 2: Fallait trouver :");
                jeu2.printCombinaison();

            }
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