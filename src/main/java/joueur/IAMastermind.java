package joueur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static joueur.PropertiesFile.getnbCasesMastermind;
import static joueur.PropertiesFile.getnbChiffreUtilisableMastermind;

public class IAMastermind extends IA {
    private int nbCasesMastermind = getnbCasesMastermind();
    private int nbChiffreUtilisableMastermind = getnbChiffreUtilisableMastermind();
    private String dernierReponse = "5555";
    private ArrayList<String> possibilitesMax;


    private void GenerateurPossibilitiesMastermind() {
        possibilitesMax = new ArrayList<>();
        if (nbCasesMastermind == 4) {
            for (byte i = 0; i < nbChiffreUtilisableMastermind; i++) {
                for (byte j = 0; j < nbChiffreUtilisableMastermind; j++) {
                    for (byte k = 0; k < nbChiffreUtilisableMastermind; k++) {
                        for (byte l = 0; l < nbChiffreUtilisableMastermind; l++) {
                            possibilitesMax.add(String.valueOf((i) + (j) + (k) + (l)));

                        }
                    }
                }

            }

        }

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
        possibilitesMax.stream().filter(combinaison -> {
            return true;
        }).collect(Collectors.toList());

        super.donnerUnIndice(indice);
    }

    @Override
    public String generateur(){
        List<Integer> v = new ArrayList();
        new Random().ints(nbCasesMastermind, 0, nbChiffreUtilisableMastermind).forEach(v::add);
        String vv="";
        for(int i = 0; i< nbCasesMastermind ; i++){
            vv = vv+v.get(i);
        };





/*

        Collections.shuffle(nbutilisable());

        List<String> vv = nbutilisable().subList(0, nbCasesMastermind);
        String v = String.valueOf(vv);
    return v;
    }
    */
/*public String generateur() {
        Random generateur = new Random();

        String v = Integer.toString(Math.abs(generateur.nextInt()));
        v = v.substring(0, dernierReponse.length());
        return v;
    }*//*

    private List<String> nbutilisable(){
        ArrayList nbUtilisable = new ArrayList();
        for (int i = 0; i <= nbChiffreUtilisableMastermind; i++){
            nbUtilisable.add(i);
        }
*/

   return vv;
    }



}
