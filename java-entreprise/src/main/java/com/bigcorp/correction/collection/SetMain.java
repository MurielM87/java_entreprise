package com.bigcorp.correction.collection;

import com.bigcorp.correction.voiture.Voiture;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {

    public static void main(String[] args) {
        //Création d'un Hashset
        Set<Voiture> voitures = new HashSet<>();

        //Ajout d'éléments au Set
        voitures.add(new Voiture("voiture 1"));
        Voiture voiture2 = new Voiture("voiture 2");
        voitures.add(voiture2);
        voitures.add(new Voiture("voiture 3"));
        voitures.add(new Voiture("voiture 4"));

        //Suppression d'éléments du Set
        voitures.remove(voiture2);
        System.out.println("La taille du set vaut : " + voitures.size());

        //Itération sur le Set. Permis car Set hérite de Iterable
        for(Voiture voiture : voitures){
            System.out.println("La voiture : " + voiture.getIdentifiant() + " est dans le set");
        }

        //Nettoyage du Set
        voitures.clear();
        System.out.println("La taille du set après clear vaut : " + voitures.size());
    }

}
