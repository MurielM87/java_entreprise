package com.bigcorp.correction.voiture;

/**
 * Modélise une Voiture.
 * Elle implémente Comparable, donc a un ordre
 * naturel, ce qui est pratique pour trier des voitures.
 */
public class Voiture implements Comparable<Voiture> {

    private int compteurKilometrique;
    private final String identifiant;
    private static int compteurVoituresCrees;
    private float pressionDesQuatrePneus;

    //Volume d'essence dans le reservoir
    private double volumeEssence;

    public Voiture(String identifiant) {
        this.identifiant = identifiant;
        compteurVoituresCrees++;
    }

    public int getCompteurKilometrique() {
        return compteurKilometrique;
    }

    public String getIdentifiant(){
        return this.identifiant;
    }

    public double getVolumeEssence() {
        return volumeEssence;
    }

    public void setVolumeEssence(double volumeEssence) {
        this.volumeEssence = volumeEssence;
    }

    public float getPressionDesQuatrePneus() {
        return pressionDesQuatrePneus;
    }

    /**
     * Fait rouler la voiture.
     * @param nombreKilometres
     */
    public void roule(int nombreKilometres){
        this.compteurKilometrique += nombreKilometres;
        //correspond à : this.compteurKilometrique = this.compteurKilometrique + nombreKilometres;

        this.pressionDesQuatrePneus -= 0.1f;
        // correspond à : this.pressionDesQuatrePneus = this.pressionDesQuatrePneus - 0.1f;
    }

    /**
     * Gonfle les pneus. Lance une Exception,
     * qui doit être déclarée avec throws.
     * @param pression
     * @throws Exception
     */
    public void gonflePneus(float pression) throws Exception {
        if(pression < 0){
            throw new Exception("La pression est négative, ce qui est interdit");
        }
        this.pressionDesQuatrePneus = pression;
    }

    /**
     * Peut lancer une RuntimeException.
     * Mais toute classe qui hérite de RuntimeException
     * peut ne pas être déclarer avec throws et catch.
     */
    public void faitUneCascade(){
        if(compteurKilometrique > 10000){
            throw new RuntimeException("t'as pas le droit");
        }
        System.out.println("Belle cascade !!");

    }

    /**
     * Cette méthode est ajoutée parce que l'on implémente
     * l'interface Comparable. Elle compare deux objets deux à deux :
     * l'objet this (celui sur lequel la méthode est appelée), et l'objet
     * autre (l'argument de la méthode).
     * Elle renvoie -1 si this est "avant" autre , ou plus petit que autre.
     * Elle renvoie 1 si this est "après" autre , ou plus grand que autre.
     * Elle renvoie 0 sinon.
     * @param autre the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Voiture autre) {
        //Algo avec des if, pour trier des voitures par  kilométrage
//        if(this.compteurKilometrique > autre.compteurKilometrique){
//            return 1;
//        }else if(this.compteurKilometrique < autre.compteurKilometrique){
//            return -1;
//        }else {
//            return 0;
//        }

        //Le même algo, avec un calcul mathématique
        return this.compteurKilometrique - autre.compteurKilometrique;

        //Un troisième algorithme de comparaison, qui se base sur
        //String.compareTo --> ceci comparera des voitures par
        //ordre alphabétique de l'identifiant croissant
        //return this.identifiant.compareTo(autre.identifiant);
    }
}
