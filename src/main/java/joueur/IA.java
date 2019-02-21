package joueur;

public abstract class IA implements Joueur {

    @Override
    public String demanderNbrAleatoire() {
        System.out.println("Combinaison secrète initié !");
        String cs = generateur();
        return cs;
    }

    protected abstract String generateur();
}
