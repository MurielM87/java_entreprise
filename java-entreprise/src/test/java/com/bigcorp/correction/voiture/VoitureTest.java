package com.bigcorp.correction.voiture;

import org.junit.jupiter.api.*;

/**
 * Classe de Test pour les méthodes de la classe
 * Voiture
 */
public class VoitureTest {

    private static Connection connection;

    @BeforeEach
    public void logAvantChaqueTest(){
        System.out.println("Cette méthode est annotée avec BeforeEach");
        connection.nettoieTableVoiture();
    }

    @AfterEach
    public void logApresChaqueTest(){
        System.out.println("Cette méthode est annotée avec AfterEach");
    }

    @BeforeAll
    public static void logAvantToutTest(){
        System.out.println("Cette méthode est annotée avec BeforeAll");
        connection = new Connection();
        connection.connect();
    }

    @AfterAll
    public static void logApresToutTest(){
        System.out.println("Cette méthode est annotée avec AfterAll");
        connection.disconnect();
    }

    @Test
    public void testInutile() {
        System.out.println("Execution du test inutile");
    }

    @Test
    public void testCompteurKilometrique(){
        System.out.println("Execution du test compteur kilométrique");

        //Arrange
        Voiture voiture = new Voiture("voiture-test");

        //Act
        voiture.roule(20);
        voiture.roule(10);
        int compteurKilometrique = voiture.getCompteurKilometrique();

        //Assert
        Assertions.assertEquals(30, compteurKilometrique);
    }

    @Test
    public void testVolumeEssence(){
        System.out.println("Execution du test de volume essence");

        //Arrange
        Voiture voiture = new Voiture("voiture-test");

        //Act
        voiture.setVolumeEssence(34.55f);

        //Assert
        Assertions.assertEquals(34.56f, voiture.getVolumeEssence(), 0.02);
    }

    @Test
    public void testVolumeEssence2(){
        System.out.println("Execution du test de volume essence, version 2");

        //Given
        Voiture voiture = new Voiture("voiture-test-encore");
        voiture.setVolumeEssence(50.55f);

        //When
        double volumeEssence = voiture.getVolumeEssence();

        //Then
        Assertions.assertEquals(50.55f, volumeEssence, 0.001f);

    }
}
