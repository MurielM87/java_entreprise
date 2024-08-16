package com.bigcorp.correction.collection;

import com.bigcorp.correction.voiture.Voiture;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/***
 *Utilisation de  Map, ensemble de (clé->valeur)
 */
public class MapMain {

    public static void main(String[] args) {

        //Utilisation de HashMap
        Map<String, Voiture> voitureParIdentifiants = new HashMap<>();

        //Création de voiture
        String numeroImmatriculation = "DD-098-DD";
        Voiture voiture = new Voiture(numeroImmatriculation);
        voiture.roule(100);

        //Ajout à la map
        voitureParIdentifiants.put(numeroImmatriculation, voiture);
        System.out.println("La Map contient : " + voitureParIdentifiants.size() + " élements.");

        //Récupération d'une valeur de la map par sa clé
        Voiture voitureDeLaMap = voitureParIdentifiants.get(numeroImmatriculation);
        System.out.println("La voiture qui vient de la map a comme identifiant "
                + voitureDeLaMap.getIdentifiant());

        //Ajout d'une autre voiture avec la même clé : l'ancien élément de
        //la map est écrasée
        Voiture voiture2 = new Voiture("autreNumeroImmatriculation");
        voiture2.roule(20);
        voitureParIdentifiants.put(numeroImmatriculation, voiture2);

        //Récupération d'une valeur de la map par sa clé
        voitureDeLaMap = voitureParIdentifiants.get(numeroImmatriculation);
        System.out.println("La voiture qui vient de la map (mais qui a été remplacée) a comme identifiant "
                + voitureDeLaMap.getIdentifiant());

        //Suppression d'une valeur de la map par sa clé
        voitureParIdentifiants.remove(numeroImmatriculation);
        System.out.println("La Map contient : " + voitureParIdentifiants.size() + " élements, après un remove.");

        //Nettoyage de la map
        voitureParIdentifiants.clear();

        System.out.println("La Map contient : " + voitureParIdentifiants.size() + " élements, après un clear.");


        //Utilisation d'une treemap, qui va trier ses éléments
        //selon l'ordre naturel des clés.
        //L'ordre naturel est déterminé par le fait que la classe
        //des clés implémente l'interface Comparable
        System.out.println("Utilisation de TreeMap avec une String en clé");
        Map<String, String> dico = new TreeMap<>();
        dico.put("aahh", "Cri");
        dico.put("véranda", "Truc dans une maison");
        dico.put("pizza", "Plat délicieux, surtout avec des pigeons");
        dico.put("truc", "Objet indéfini");
        dico.put("pigeon", "Volatile délicieux, surtout dans des pizzas");


        for (String key : dico.keySet()){
            System.out.println("Clé : " + key + " : valeur : " + dico.get(key));
        }

        //Utilisation d'une treemap, qui va trier ses éléments
        //selon le comparateur fourni au constructeur.
        System.out.println("Utilisation de TreeMap avec une Voiture en clé");
        Map<Voiture, String> proprietairesDesVoitures = new TreeMap<>(new VoitureComparatorByPressionDesPneus());
        proprietairesDesVoitures.put(voiture, "Jean");
        proprietairesDesVoitures.put(voiture2, "Paulette");

        for (Voiture voitureDansLaBoucle : proprietairesDesVoitures.keySet()){
            System.out.println("Pour la voiture avec l'identifiant : "
                    + voitureDansLaBoucle.getIdentifiant()
                    + " : le propriétaire est : " + proprietairesDesVoitures.get(voitureDansLaBoucle));
        }



    }
}
