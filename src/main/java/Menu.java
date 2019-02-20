import config.PropertiesFile;
import jeu.Jeu;
import jeu.Mastermind;
import jeu.RechercheNbr;
import joueur.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private Scanner sc = new Scanner(System.in);
    private String selectionChoixJeu = "";
    private Jeu choixJeu;
    private int selectionChoixMode;
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

        if (Main.developpeurMode) {
            System.out.println("Mode Développeur Activé -->");
            jeu1.printCombinaison();
        }

        int compteurTentative = 0; // compteurTentative: is loop counter
        while (!jeu1.isFini() && compteurTentative < nbTentativeLimite()) {
            compteurTentative++;
            jeu1.jouerTour();


        }
        if (!jeu1.isFini() && compteurTentative == nbTentativeLimite()) {
            System.out.println("\nGAME OVER \nNombre de tentatives maximales atteind");

        } else {
            System.out.println("\n*** !!BRAVO!! ***\n");

        }
        jeu1.printCombinaison();

        if (compteurTentative > 1) {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentatives");
        } else {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentative");
        }
        choixFinDuJeu();
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

        if (Main.developpeurMode) {
            jeu1.printCombinaison();
        }

        int compteurTentative = 0; // compteurTentative: is loop counter
        while (!jeu1.isFini() && compteurTentative < nbTentativeLimite()) {
            compteurTentative++;
            jeu1.jouerTour();

        }
        if (!jeu1.isFini() && compteurTentative == nbTentativeLimite()) {
            System.out.println("\n*********\nGAME OVER\n*********\nNombre de tentatives maximales atteind");
        } else {
            System.out.println("\nBravo\n");
        }
        jeu1.printCombinaison();
        if (compteurTentative > 1) {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentatives");
        } else {
            System.out.println("Le jeu est fini en  " + compteurTentative + " tentative");
        }
        choixFinDuJeu();
    }


    private void duel() {
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
        jeu2.setJoueur(joueur2, joueur1);

        System.out.println("\nJOUEUR 1");
        jeu2.premierTour();
        System.out.println("\nJOUEUR 2 (Le RoBoT) :");
        jeu1.premierTour();


        int compteurTentative = 0; // compteurTentative

        boolean alternateurJoueur = false;

        while (!jeu1.isFini() && !jeu2.isFini() && compteurTentative < nbTentativeLimite()) {
            if (!jeu1.isFini() && !jeu2.isFini() && !alternateurJoueur) {
                compteurTentative++;
                System.out.println("\nJOUEUR 1");
                jeu1.jouerTour();


                if (jeu1.isFini()) {
                    System.out.print("\nBravo Joueur 1 Win!!");
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

                System.out.println("\nJOUEUR 2 (Le RoBoT)");
                jeu2.jouerTour();


                if (jeu2.isFini()) {
                    System.out.print("\nBravo Joueur 2 (Le RoBoT) Win!!");
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
                System.out.println("\n*********\nGAME OVER\n*********\nNombre de tentatives maximales atteind");
                System.out.println("Joueur 1: Fallait trouver :");
                jeu1.printCombinaison();
                System.out.println("Joueur 2 (Le RoBoT): Fallait trouver :");
                jeu2.printCombinaison();

            }
        }
        choixFinDuJeu();
    }


    public void choixDuJeu() {

        System.out.println("\n************************************************ \n    Bienvenue au Projet3 <OpenClassRoom!> \n************************************************ \n \n 1/ Recherche Combinaison Secrète +/-. \n 2/ MasterMind. \n \n Veuillez Selectionner un jeu: \n");
        this.selectionChoixJeu = sc.nextLine();
        if (selectionChoixJeu.equals("1") || selectionChoixJeu.equals("Recherche Combinaison Secrete +/-") || selectionChoixJeu.equals("Recherche Combinaison Secrete")) {
            logger.info("Choix du jeu Recherche Nbr +/- Activé");
            choixJeu = new RechercheNbr();
            selectionChoixJeu = "1";
            choixDuMode();
        } else if (selectionChoixJeu.equals("2") || selectionChoixJeu.equals("MasterMind")) {
            logger.info("Choix du jeu Mastermind Activé");
            choixJeu = new Mastermind();
            selectionChoixJeu = "2";
            choixDuMode();
        } else {
            logger.error("Choix du Jeu non prit en compte");
            System.out.println("\n De nouveau veuillez sélectionner le numéro associé au jeu.");
            this.choixDuJeu();
        }

    }

    private void choixDuMode() {
        System.out.println("\n************************ \n Mode De Jeu ?\n************************ \n 1/ Challenger. \n 2/ Défenseur. \n 3/ Duel. \n Veuillez insérez le numéro de mode de jeu désiré: \n");
        selectionChoixMode = sc.nextInt();
        switch (selectionChoixMode) {
            case 1:
                logger.info("Mode Challenger Activé");
                this.challenger();
                break;
            case 2:
                logger.info("Mode Défenseur Activé");
                this.defenseur();
                break;
            case 3:
                logger.info("Mode Duel Activé");
                this.duel();
                break;

            default:
                logger.error("ChoixDuMode non prit en compte");
                System.out.println("\nDe Nouveau, Veuillez insérez un numéro de mode valide!");
                choixDuMode();
                break;
        }
    }

    private void choixFinDuJeu() {
        System.out.println("\n**********************\n 1/ Quitter. \n 2/ Rejouer. \n 3/ Revenir Au Menu Principal.\nQue Souhaitez Vous: ");
        Scanner sc = new Scanner(System.in);
        String selectionChoixFinJeu = sc.nextLine();

        if (selectionChoixFinJeu.equals("1") || selectionChoixFinJeu.equals("Quitter")) {
            logger.info("Quitter le jeux normalement");
            System.exit(0);
        } else if ((selectionChoixFinJeu.equals("2") || selectionChoixFinJeu.equals("Rejouer"))) {
            logger.info("Rejouer Choix");
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
            }
        } else if (selectionChoixFinJeu.equals("3") || selectionChoixFinJeu.equals("Revenir Au Menu Principal")) {
            logger.info("Retour au menu principale");
            this.choixDuJeu();
        }
    }

}