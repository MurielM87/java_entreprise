package com.bigcorp.correction.tpcsv;

import java.util.Scanner;

/**
 * Lance le code du TP CSV.
 * Gère aussi les entrée et les sortie du terminal et vers le terminal
 */
public class TpCsv {

    public static void main(String[] args) {

        //Création du dictionnaire
        Dictionnaire dictionnaire = new Dictionnaire();

        try (Scanner input = new Scanner(System.in)) {
            dictionnaire.charger();

            //Gestion des entrées de l'utilisateur
            boolean stop = false;
            while (!stop) {
                System.out.println("Entrez un nombre: ");
                System.out.println("1 pour afficher tous les mots");
                System.out.println("2 pour écrire un fichier CSV ");
                System.out.println("3 pour afficher la définition d'un mot ");
                System.out.println("Autre pour quitter ");
                int choixInt = Integer.parseInt(input.nextLine());
                switch (choixInt) {
                    case 1 -> {
                        dictionnaire.afficherDansConsole();
                    }
                    case 2 -> {
                        dictionnaire.sauvegarder();
                        System.out.println("Données sauvegardées");
                    }
                    case 3 -> {
                        System.out.print("Entrez un mot : ");
                        String mot = input.nextLine();
                        System.out.println("La définition du mot est : " + dictionnaire.getDefinition(mot));
                    }
                    default -> {
                        stop = true;
                    }

                }
            }
            //Gros bloc try / catch qui récupère toute exception et affiche un message d'erreur
        } catch (Exception e) {
            System.out.println("Désolé, une erreur est survenue.");
            e.printStackTrace();
        }
        System.out.println("Fin du programme");

    }
}
