package joueur;

import java.util.Scanner;

public class Humain implements Joueur {
    Scanner sc = new Scanner(System.in);


    @Override
    public String demanderNbrAleatoire() {

        System.out.println("Veuillez Insérez une combinaison secrète: ");
        String cs = sc.nextLine();

        return cs;
    }

    @Override
    public String demanderNbrReponse() {

        System.out.println("Insérez votre proposition : ");
        String css = sc.nextLine();

        return css;
    }

    @Override
    public void donnerUnIndice(String indice) {
        System.out.println("\n Indice : " + indice);


    }

}
