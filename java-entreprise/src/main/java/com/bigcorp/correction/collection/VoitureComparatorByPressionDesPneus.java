package com.bigcorp.correction.collection;

import com.bigcorp.correction.voiture.Voiture;

import java.util.Comparator;

/**
 * Toute classe implémentant Comparator permet
 * de comparer des éléments 2 à 2. Ceci est utilisé
 * par bon nombre de classes Java, ou d'autres bibliothèques
 * pour trier des élements.
 */
public class VoitureComparatorByPressionDesPneus implements Comparator<Voiture>{

    public int compare(Voiture o1, Voiture o2) {
        return (int) (o1.getPressionDesQuatrePneus() - o2.getPressionDesQuatrePneus());
    }
}
