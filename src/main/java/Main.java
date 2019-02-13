
import joueur.PropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
     public static Logger logger = LogManager.getLogger(Main.class);



    public static void main(String[] args) {
        boolean developpeurMode = false;

        if ((PropertiesFile.getModeDev()) || (args.length > 0 && args[0].equals("-dev"))) {
            logger.info("mode développeur activé!");
             developpeurMode = true;
        }
        logger.info("Lancement du Projet3");
        new Menu().choixDuJeu();


    }

}
