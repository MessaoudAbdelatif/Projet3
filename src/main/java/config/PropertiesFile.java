package config;

import java.util.ResourceBundle;

public class PropertiesFile {
    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static String getnbCasesRechercheplusoumoins() {
        String indiceSet = rb.getString("nbCasesRechercheplusoumoins");
        return indiceSet;
    }

    public static Boolean getModeDev() {      //TODO SET CONFIG DEV MODE
        boolean getModeDev;
        getModeDev = rb.getString("modeDeveloppeur").equals("true");
        return getModeDev;
    }

    public static int getnbCasesMastermind() {
        int nbCasesMastermind = Integer.valueOf(rb.getString("nbCasesMastermind"));
        return nbCasesMastermind;
    }

    public static int getnbTentativesPossibleRechercheplusoumoins() {
        int nbTentativesPossibleRechercheplusoumoins = Integer.valueOf(rb.getString("nbTentativesPossibleRechercheplusoumoins"));
        return nbTentativesPossibleRechercheplusoumoins;
    }

    public static int getnbTentativesPossibleMastermind() {
        int nbTentativesPossibleMastermind = Integer.valueOf(rb.getString("nbTentativesPossibleMastermind"));
        return nbTentativesPossibleMastermind;
    }

    public static int getnbChiffreUtilisableMastermind() {
        int nbChiffreUtilisableMastermind = Integer.valueOf(rb.getString("nbChiffreUtilisableMastermind"));
        return nbChiffreUtilisableMastermind;
    }

}