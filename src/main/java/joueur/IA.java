package joueur;

public abstract class IA implements Joueur {
    private String dernierReponse = "";


    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrète initié !");
        String cs = "";
        return cs;
    }

    @Override
    public String demanderNbrReponse() {
        System.out.println("Insérez votre proposition : " + dernierReponse);

        return dernierReponse;

    }

    @Override
    public void donnerUnIndice(String indice) {

    }

    public String generateur() {
        String generateurRandom = "";
        return generateurRandom;

    }
}
