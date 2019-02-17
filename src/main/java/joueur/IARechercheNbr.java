package joueur;

import java.util.Random;
import static config.PropertiesFile.getnbCasesRechercheplusoumoins;


public class IARechercheNbr extends IA {

    private String dernierReponse = dernierReponseInit();
    private char[] resultat = new char[dernierReponse.length()];
    private int[] borneMax = new int[dernierReponse.length()];
    private int[] borneMin = new int[dernierReponse.length()];


    private String dernierReponseInit() {

        String indiceSet = "";
        int j;
        j = Integer.valueOf(getnbCasesRechercheplusoumoins());
        for (int i = 0; i < j; i++) {
            indiceSet = indiceSet + "5";
        }
        return indiceSet;


    }

    public String demanderNbrAleatoire() {

        System.out.println("Combinaison secrète initié !");
        String cs = generateur();

        return cs;
    }


    public String demanderNbrReponse() {

        System.out.println("Insérez votre proposition : " + dernierReponse);

        return dernierReponse;
    }

    public String generateur() {

        Random generateur = new Random();
        String generateurRandom = Integer.toString(Math.abs(generateur.nextInt()));
        generateurRandom = generateurRandom.substring(0, dernierReponse.length());

        return generateurRandom;
    }

    @Override
    public void donnerUnIndice(String indice) {


        System.out.println(" Indice : " + indice);
        char[] tabIndice = indice.toCharArray();

        for (int i = 0; i < resultat.length; i++) {
            if (dernierReponse.equals(dernierReponseInit())) {
                borneMin[i] = 0;
                borneMax[i] = 9;
            }

            switch (tabIndice[i]) {
                case '=':
                    resultat[i] = dernierReponse.charAt(i);

                    break;
                case '-':
                    borneMax[i] = Character.getNumericValue(dernierReponse.charAt(i));
                    resultat[i] = Character.forDigit((borneMax[i] + borneMin[i]) / 2, 10);

                    break;
                case '+':
                    borneMin[i] = Character.getNumericValue(dernierReponse.charAt(i));
                    if ((borneMax[i] + borneMin[i]) % 2 == 0) {
                        resultat[i] = Character.forDigit((borneMax[i] + borneMin[i]) / 2, 10);

                    } else {
                        resultat[i] = Character.forDigit(((borneMax[i] + borneMin[i]) / 2) + 1, 10);

                    }

                    break;
            }

        }
        dernierReponse = String.valueOf(resultat);

    }
}