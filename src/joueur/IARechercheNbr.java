package joueur;


import java.util.Random;

public class IARechercheNbr extends IA {

    private String dernierReponse = "5555";
    char[] resultat = new char[dernierReponse.length()];
    int[] borneMax = new int[dernierReponse.length()];
    int[] borneMin = new int[dernierReponse.length()];


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


        for (int i = 0; i < resultat.length; i++) {
            if (dernierReponse == "5555") {
                borneMin[i] = 0;
                borneMax[i] = 9;
            }


                switch (tabIndice[i]) {
                    case '=':
                        resultat[i] = dernierReponse.charAt(i);

                        break;
                    case '-':
                        borneMax[i] = Character.getNumericValue(dernierReponse.charAt(i));
                        resultat[i] = Character.forDigit((borneMax[i] + borneMin[i]) / 2, 10);

                        break;
                    case '+':
                        borneMin[i] = Character.getNumericValue(dernierReponse.charAt(i));
                        if ((borneMax[i] + borneMin[i]) % 2 == 0) {
                            resultat[i] = Character.forDigit((borneMax[i] + borneMin[i]) / 2, 10);

                        } else {
                            resultat[i] = Character.forDigit(((borneMax[i] + borneMin[i]) / 2) + 1, 10);

                        }

                        break;
                }

            }
            dernierReponse = String.valueOf(resultat);

        }
    }