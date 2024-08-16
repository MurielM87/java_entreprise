package com.bigcorp.correction.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutreLog {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    static int calculerPuissance() {
        double resultatPuissance = Math.pow(2,3);
        LOGGER.trace("détail calcul puissance : " + resultatPuissance);
        System.out.println("resultat puissance : " + resultatPuissance);
        return (int) resultatPuissance;
    }

}
