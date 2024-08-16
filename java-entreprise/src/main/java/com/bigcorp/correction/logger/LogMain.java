package com.bigcorp.correction.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {

    //créer log
    private static final Logger LOGGER = LoggerFactory.getLogger(LogMain.class); //méthode static pour ne l'appeler qu'une seule fois

    public static void main(String[] args) {
        LogMain logMain = new LogMain();

        //l'exception remonte à la méthode du dessus
        int resultat = 0;
        try {
            resultat = logMain.additionner(3,5);
        } catch (Exception e) {
            e.getMessage();
            //throw new RuntimeException(e);
            //OU throw new Eception("message choisi");
        }
        System.out.println("résultat addition : " + resultat);

        resultat = logMain.calcule1(3,5);
        System.out.println("résultat calcul1 : " + resultat); //si b = 5, division par 0, alors error

        resultat = logMain.puissance(3,5);
        System.out.println("resultat puissance" + resultat);
    }

    private int puissance(int a, int b) {
        int resultat = 1;
        for (int i = 0; i < b; i++) {
            LOGGER.debug("calcul puissance : " + resultat);
            resultat *=a;
        }
        return resultat;
    }

    private int calcule1(int a, int b) {
        LOGGER.info("je calcule avec a = " + a + " et b = " + b);
        try {
            return a / (5 - b);
        } catch(Exception e) {
            LOGGER.error("une erreur grave est survenue", e);
            //throw e //relancer e
            return 0;
        }

    }

    private int additionner(int a, int b) throws Exception {
        LOGGER.info("j'additionne avec a = " + a + " et b = " + b);
        throw new Exception("ne fonctionne pas");
        //return a + b;
    }
}
