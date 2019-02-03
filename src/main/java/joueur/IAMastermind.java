package joueur;

import jeu.Mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static joueur.PropertiesFile.getnbCasesMastermind;
import static joueur.PropertiesFile.getnbChiffreUtilisableMastermind;

public class IAMastermind extends IA {
    private int nbCasesMastermind = getnbCasesMastermind();
    private int nbChiffreUtilisableMastermind = getnbChiffreUtilisableMastermind();
    private String dernierReponse = dernierReponseInit();
    private ArrayList<String> allPossibilites;



    private void generateurAllPossibilitiesMastermind() {
        allPossibilites = new ArrayList<>();
        if (nbCasesMastermind == 4) {
            for (byte i = 0; i < nbChiffreUtilisableMastermind; i++) {
                for (byte j = 0; j < nbChiffreUtilisableMastermind; j++) {
                    for (byte k = 0; k < nbChiffreUtilisableMastermind; k++) {
                        for (byte l = 0; l < nbChiffreUtilisableMastermind; l++) {
                            allPossibilites.add(String.valueOf((i) + (j) + (k) + (l)));

                        }
                    }
                }

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
        System.out.println("Combinaison secrete initié par votre adversaire !");
        String cs = generateur();
        return cs;
    }

    @Override
    public String demanderNbrReponse() {
        System.out.println("Inserez votre proposition : " + dernierReponse);
        return dernierReponse;
    }

    @Override
    public void donnerUnIndice(String indice) {
        System.out.println(" Indice : " + indice);
        generateurAllPossibilitiesMastermind();
        List<String> possibilities = allPossibilites.stream()
                .filter(x-> (new Mastermind().comparaisonLogique(x,dernierReponse)).equals(indice))
               /* .map(x -> new Mastermind().comparaisonLogique(x, dernierReponse))
                .filter(x -> indice.equals(x))*/
                .collect(Collectors.toList());
        dernierReponse = String.valueOf(possibilities.get(1));


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
