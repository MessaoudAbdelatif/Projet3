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

        System.out.println("Inserez votre proposition : " + dernierReponse);

        return dernierReponse;
    }

    @Override
    public void donnerUnIndice(String indice) {
        System.out.println(" Indice : " + indice);
        char tabIndice[] = indice.toCharArray();
        char resultat[] = new char[tabIndice.length];
        for (int i = 0; i < tabIndice.length; i++) {
            if (tabIndice[i] == '+') {
                resultat[i] = (char) (Integer.valueOf(this.dernierReponse.charAt(i)) + 1);
            } else if (tabIndice[i] == '-') {
                resultat[i] = (char) (Integer.valueOf(this.dernierReponse.charAt(i)) - 1);

            } else if (tabIndice[i] == '=') {
                resultat[i] = (char) (Integer.valueOf(this.dernierReponse.charAt(i)) + 0);
            }


        }
        dernierReponse = String.valueOf(resultat);


    }

    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, 4);
        return v;
    }
}