package joueur;

import java.util.ResourceBundle;

public class PropertiesFile {
    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public String getnbCasesRechercheplusoumoins() {
        int i;
        int j = Integer.valueOf(rb.getString("nbCasesRechercheplusoumoins"));
        String indiceSet = "";
        for (i = 0; i < j; i++) {
            indiceSet = indiceSet + "5";
        }
        return indiceSet;
    }
    public Boolean getModeDev(){
        Boolean getModeDev;
        if(rb.getString("modeDeveloppeur") == "true"){
            getModeDev = true;
        }else {
            getModeDev = false;
        }
        return getModeDev;
    }
}