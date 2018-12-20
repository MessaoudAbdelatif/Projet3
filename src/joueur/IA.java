package joueur;

import jeu.RechercheNbr;
import java.util.Scanner;


public class IA implements Joueur {
    Scanner sc = new Scanner(System.in);

    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrete initié par votre adversaire !");
        String cs = new RechercheNbr().generateur();
        return cs;
    }

    @Override
    public String demanderNbrReponse() {

        System.out.println("Inserez votre proposition : ");

        return null;
    }

    @Override
    public void donnerUnIndice(String indice) {
        System.out.println(" Indice : " + indice);

    }
}