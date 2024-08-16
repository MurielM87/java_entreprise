package com.bigcorp.correction.tpcsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe de gestion d'un Dictionnaire,
 * que l'on peut charger à partir d'un fichier CSV
 * et que l'on peut sauvegarder dans un fichier CSV.
 */
public class Dictionnaire {

    /**
     * Utilisation de static et final pour créer des constantes. Elles ne concernent
     * que la classe et sont donc private
     */
    private static final String FICHIER_ENTREE = "entree.csv";
    private static final String FICHIER_SORTIE = "sortie.csv";


    /**
     * Variable d'instance : une TreeMap qui va stocker les données (triées selon la clé)
     */
    private Map<String, String> dictionnaire = new TreeMap<String, String>();

    /**
     * Remplit le dictionnaire à partir d'un fichier CSV
     *
     */
    public void charger() throws Exception {
        //Utilisation du try with resources
        //pour que ces ressources soient bien fermées
        //quoiqu'il arrive
        try (FileReader fr = new FileReader(FICHIER_ENTREE);
             CSVReader reader = new CSVReaderBuilder(fr).build();
        ) {
            //Utilisation d'une variable temporaire nextLine
            String[] nextLine = reader.readNext();
            while (nextLine != null) {
                dictionnaire.put(nextLine[0], nextLine[1]);
                nextLine = reader.readNext();
            }
        }

    }


    /**
     * Sauvegarde le dictionnaire dans un fichier CSV
     *
     *
     */
    public void sauvegarder() throws Exception {
        //Utilisation du try with resources
        //pour que ces ressources soient bien fermées
        //quoiqu'il arrive
        try (FileWriter fw = new FileWriter(FICHIER_SORTIE);
             ICSVWriter writer = new CSVWriterBuilder(fw).build()) {

            //Itération sur toutes les clés de la map
            //(on aurait pu itérer sur les entries)
            for (String mot : dictionnaire.keySet()) {
                //Pour chaque clé, création d'un
                //petit tableau temporaire et remplissage
                //de celui-ci.
                //Pourquoi ? Parce que notre  writer
                // a besoin d'un tableau pour écrire chacune
                // des lignes de CSV.
                String[] entree = new String[2];
                entree[0] = mot;
                entree[1] = dictionnaire.get(mot);
                writer.writeNext(entree);
            }
        }
    }

    /**
     * Affiche tout le dictionnaire dans la console
     */
    public void afficherDansConsole() {
        //Ici, itération sur les entries de la map
        System.out.println("Affichage du dictionnaire");
        for(Map.Entry<String, String> entry : dictionnaire.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * Renvoie la définition liée à un mot.
     * Peut renvoyer null si aucune définition ne correspond.
     * @param mot
     * @return
     */
    public String getDefinition(String mot) {
        return dictionnaire.get(mot);
    }
}