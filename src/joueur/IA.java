package joueur;

import java.util.Random;


public class IA implements Joueur {
    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrete initié par votre adversaire !");
        String cs = generateur();
        return cs;
    }

    @Override
    public String demanderNbrReponse() {
        return null;
    }

    @Override
    public void donnerUnIndice(String indice) {
        System.out.println(" Indice : " + indice);

    }

    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, 4);
        return v;
    }
}