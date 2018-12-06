import jeu.Jeu;
import jeu.RechercheNbr;
import joueur.Humain;
import joueur.Joueur;

public class Main {

    public static void main(String[] args) {
        Joueur joueur1 = new Humain();
        Joueur joueur2 = new Humain();

        Jeu jeu1 = new RechercheNbr();
        jeu1.setJoueur(joueur1, joueur2);
        jeu1.jouerTour();
        while (jeu1.isFini() == false){
            jeu1.jouerTour();
        }





        
    }

}
