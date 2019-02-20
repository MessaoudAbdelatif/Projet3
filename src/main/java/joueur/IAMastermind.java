package joueur;

import jeu.Mastermind;

import java.util.*;
import java.util.stream.Collectors;


import static config.PropertiesFile.getnbCasesMastermind;
import static config.PropertiesFile.getnbChiffreUtilisableMastermind;

public class IAMastermind extends IA {
    private int nbCasesMastermind = getnbCasesMastermind();
    private int nbChiffreUtilisableMastermind = getnbChiffreUtilisableMastermind();
    private String dernierReponse = dernierReponseInit();
    private List<String> allPossibilites;
    private String c = "";


    public IAMastermind() {

        generateurAllPossibilitiesMastermind();
    }

    private void generateurAllPossibilitiesMastermind() {
        int maxAllPossibilities = (int) (Math.pow(10, nbCasesMastermind));    // 10 ici représente le nombre maximal de (couleurs ou nombres) indiqué dans l'énoncé du projet.
        int dimensionnementAllPossibilities = (int) (Math.pow(nbChiffreUtilisableMastermind, nbCasesMastermind));


        for (int a = nbChiffreUtilisableMastermind; a < 10; a++) {
            String badnb = Integer.toString(a);
            c = c + badnb;

        }
        char[] nbNonUtilisable = c.toCharArray();
        allPossibilites = new ArrayList<>();
        for (int i = 0; i < maxAllPossibilities && allPossibilites.size() < dimensionnementAllPossibilities; i++) {
            String nb = Integer.toString(i);
            char[] nbChar = nb.toCharArray();
            boolean radar = false;
            for (int j = 0; j < nbNonUtilisable.length; j++) {
                for (int k = 0; k < nbChar.length; k++) {
                    if (nbNonUtilisable[j] == nbChar[k]) {
                        radar = true;
                    }
                }
            }

            if (!radar) {
                while (nb.length() < nbCasesMastermind)
                    nb = 0 + nb;
                allPossibilites.add(nb);
            }

        }
    }


    // Méthode permettant d'initie la 1er réponse de notre IA (optimisé selon KNUTH "1122" et s'adapte à la longeur du jeu)

    private String dernierReponseInit() {
        String indiceSet = "";
        for (int i = 0; i < (nbCasesMastermind / 2); i++) {
            indiceSet = indiceSet + "1";
        }
        for (int j = indiceSet.length(); j < nbCasesMastermind; j++) {
            indiceSet = indiceSet + "2";
        }
        return indiceSet;


    }

    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrète initié !");
        String cs = generateur();
        return cs;
    }

    @Override
    public String demanderNbrReponse() {
        System.out.println("Insérez votre proposition : " + dernierReponse);
        return dernierReponse;
    }


    @Override
    public void donnerUnIndice(String indice) {
        System.out.println("\n Indice : " + indice);

        allPossibilites = allPossibilites.parallelStream()
                .filter(x -> (new Mastermind().comparaisonLogique(dernierReponse, x)).equals(indice))
                .collect(Collectors.toList());
        dernierReponse = allPossibilites.get(0);


    }

    @Override
    public String generateur() {
        List<Integer> randomList = new ArrayList();
        new Random().ints(nbCasesMastermind, 0, nbChiffreUtilisableMastermind).forEach(randomList::add);
        String generateurRandom = "";
        for (int i = 0; i < nbCasesMastermind; i++) {
            generateurRandom = generateurRandom + randomList.get(i);
        }
        return generateurRandom;

    }


}
