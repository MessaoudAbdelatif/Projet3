package joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IAMastermind extends IA {
    private String dernierReponse = "5555";

    private void GenerateurPossibilitiesMastermind(){
List<String> possibilitesMax = new ArrayList<>();


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
