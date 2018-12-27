package joueur;


import java.util.Random;


public class IA implements Joueur {

    private String dernierReponse = "5555";

    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrete initié par votre adversaire !");
        String cs = generateur();
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
        char tab[] = indice.toCharArray();
        char resultat[] = new char[tab.length];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == '+') {
                resultat[i] = (char) (dernierReponse.charAt(i) + 1);
            }
            if (tab[i] == '-') {
                resultat[i] = (char) (dernierReponse.charAt(i) - 1);

            }
            if ( tab [i] == '+' ) {
                resultat[i] = (char) (dernierReponse.charAt(i) + 1);
            }


        }
    }

    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, 4);
        return v;
    }
}