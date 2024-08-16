package com.bigcorp.correction.voiture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Classe de Test pour les méthodes de la classe
 * VoiturePourReventeTest
 */
public class VoiturePourReventeTest {

    @Test
    public void testPrixReventeVoitureAvecMoins10_000Km(){
        //Arrange
        VoiturePourRevente v = new VoiturePourRevente();
        v.setPrixAchat(5_000);
        v.setKilometrage(8000);

        //Act
        int valeurRevente = v.getValeurRevente();

        //Assert
        Assertions.assertEquals(5_000, valeurRevente);

    }

    @Test
    public void testPrixReventeVoitureAvecMoins10_000Km_2(){
        //Arrange
        VoiturePourRevente v = new VoiturePourRevente();
        int prixAchat = 15_000;
        v.setPrixAchat(prixAchat);
        v.setKilometrage(5000);

        //Act
        int valeurRevente = v.getValeurRevente();

        //Assert
        Assertions.assertEquals(prixAchat, valeurRevente);

    }

    @Test
    public void testPrixReventeVoitureAvecMoins10_000Km_3(){
        //Arrange
        VoiturePourRevente v = new VoiturePourRevente();
        int prixAchat = 15_000;
        v.setPrixAchat(prixAchat);
        v.setKilometrage(0);

        //Act
        int valeurRevente = v.getValeurRevente();

        //Assert
        Assertions.assertEquals(prixAchat, valeurRevente);

    }

    @Test
    public void testPrixReventeVoitureAvecPlus10_000Km_1(){
        //Arrange
        VoiturePourRevente v = new VoiturePourRevente();
        int prixAchat = 8000;
        v.setPrixAchat(prixAchat);
        v.setKilometrage(11000);

        //Act
        int valeurRevente = v.getValeurRevente();

        //Assert
        Assertions.assertEquals(7000, valeurRevente);

    }

}
