
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static void main(String[] args) {
        boolean developpeurMode = false;


        if ((rb.getString("modeDeveloppeur").equals("true")) || (args.length > 0 && args[0].equals("-dev"))) {
            logger.info("mode développeur activé!");
            developpeurMode = true;
        }
        logger.info("Lancement du Projet3");
        new Menu().choixDuJeu();


    }

}
