package joueur;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    protected Properties config;
    protected InputStream input = PropertiesFile.class.getClassLoader().getResourceAsStream("src/main/resources/config.properties");

    public PropertiesFile() throws Exception {
        config = new Properties();
        config.load(input);

    }

    public String getnbCasesRechercheplusoumoins() {
        int i;
        int j = Integer.valueOf(config.getProperty("nbCasesRechercheplusoumoins"));
        String indiceSet = "";
        for (i = 0; i <= j; i++) {
            indiceSet = indiceSet + "5";
        }
        return indiceSet;
    }


}