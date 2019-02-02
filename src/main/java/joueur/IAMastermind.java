package joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static joueur.PropertiesFile.getnbCasesMastermind;
import static joueur.PropertiesFile.getnbChiffreUtilisableMastermind;

public class IAMastermind extends IA {
    private int nbCasesMastermind = getnbCasesMastermind();
    private int nbChiffreUtilisableMastermind = getnbChiffreUtilisableMastermind();
    private String dernierReponse = "";
    private ArrayList<String> allPossibilites;


    private void GenerateurAllPossibilitiesMastermind() {
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


    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrete initié par votre adversaire !");
        String cs = generateur();
        return cs;
    }

    @Override
    public String demanderNbrReponse() {
        System.out.println("Inserez votre proposition : " + dernierReponse);
        //TO DO SET SELON LE SIZE DE LA COMBINAISON SECRETE UNE REPONSE STYLE 1122 OU 11122 ....

        return dernierReponse;
    }

    @Override
    public void donnerUnIndice(String indice) {
        allPossibilites.stream().filter(combinaison -> {
            return true;
        }).collect(Collectors.toList());

        super.donnerUnIndice(indice);
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
