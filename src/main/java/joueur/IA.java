package joueur;

import java.util.Random;

public abstract class IA implements Joueur {
    private String dernierReponse = "5555";


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

    }

    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, 4);
        return v;


    }
}
