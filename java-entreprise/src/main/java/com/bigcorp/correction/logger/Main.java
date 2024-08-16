package com.bigcorp.correction.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Créer une classe avec des méthodes, et une instance de Logger créée avec :
private static final Logger LOGGER = LoggerFactory.getLogger(MaClasse.class);
Utiliser LOGGER.info pour logger des messages au début de chaque méthode.
UTiliser LOGGER.error pour logger des messages concernant une exception.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Main test = new Main();
        int result = test.calculer(5,5);
        System.out.println("resultat : " + result);
        result = test.calculerPuissance(2,3);
        System.out.println("résultat puissance : " + result);

    }

    private int calculer(int a, int b) {
        LOGGER.info("le calcul est " + a + " /(4 - " + b + " )");
        try {
            return a / (4 - b);
        } catch(Exception e) {
            LOGGER.trace("methode calculer");
            LOGGER.error("une erreur est survenue", e);
            return 0;
        }
    }

       private int calculerPuissance(int i, int j) {
            double resultatPuissance = Math.pow(i, j);
            LOGGER.trace("détail calcul puissance : " + resultatPuissance);
            LOGGER.debug("resultat puissance : " + resultatPuissance);
            return (int) resultatPuissance;
        }

    }
