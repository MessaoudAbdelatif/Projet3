package joueur;


import java.util.Random;

public class IARechercheNbr extends IA {

    private String dernierReponse = "5555";


    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrete initié par votre adversaire !");
        String cs = generateur();

        return cs;
    }


    public String demanderNbrReponse() {
        System.out.println("Insérez votre proposition : " + dernierReponse);

        return dernierReponse;
    }

  /* @Override
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
    }*/


    public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, 4);
        return v;
    }

    @Override
    public void donnerUnIndice(String indice) {

        System.out.println(" Indice : " + indice);
        char[] tabIndice = indice.toCharArray();
        char[] resultat = new char[dernierReponse.length()];
        int[] borneMax = new int[dernierReponse.length()];
        int[] borneMin = new int[dernierReponse.length()];


        for (int i = 0; i < tabIndice.length; i++) {

/** TODO Probleme  boucle ou casting !!**/

            borneMax[i] = 9;
            borneMin[i] = 0;

            if (tabIndice[i] == '+') {
                borneMin[i] = Integer.valueOf(this.dernierReponse.charAt(i)) + 1;
                resultat[i] = (char) (Integer.valueOf(borneMax[i] + borneMin[i] / 2).intValue());

            } else if (tabIndice[i] == '-') {
                borneMax[i] = Integer.valueOf(this.dernierReponse.charAt(i)) - 1;
                resultat[i] = (char) (Integer.valueOf(borneMax[i] + borneMin[i] / 2).intValue());

            } else if (tabIndice[i] == '=') {
                resultat[i] = (char) (Integer.valueOf(this.dernierReponse.charAt(i)) + 0);
            }

        }
        dernierReponse = String.valueOf(resultat);

    }

}