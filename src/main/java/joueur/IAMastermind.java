package joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static joueur.PropertiesFile.getnbCasesMastermind;

public class IAMastermind extends IA {
    private int nbCasesMastermind = getnbCasesMastermind();
    private String dernierReponse = "5555";
    private List<String> possibilites = new ArrayList<>();

    private List<String> GenerateurPossibilitiesMastermind() {
        List<String> possibilitesMax = new ArrayList<>();
        return possibilitesMax;


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
        possibilites.stream().filter(combinaison -> {
            return true;
        }).collect(Collectors.toList());

        super.donnerUnIndice(indice);
    }

    @Override
    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, dernierReponse.length());
        return v;
    }
}
