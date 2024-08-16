package com.bigcorp.correction.voiture;


/**
 * Classe Garage, utilise des voitures
 */
public class Garage {

    private Voiture voitureDuGarage;

    private float pressionReservoirAirComprime = -100;

    public Voiture getVoitureDuGarage() {
        return voitureDuGarage;
    }

    public void setVoitureDuGarage(Voiture voitureDuGarage) {
        this.voitureDuGarage = voitureDuGarage;
    }

    public float getPressionReservoirAirComprime() {
        return pressionReservoirAirComprime;
    }

    public void setPressionReservoirAirComprime(float pressionReservoirAirComprime) {
        this.pressionReservoirAirComprime = pressionReservoirAirComprime;
    }

    /**
     * EntretienVoiture utilise des exceptions
     * avec try catch pour gérer les problèmes qui
     * peuvent arriver (notamment quand on gonfle des pneus)
     */
    public void entretienVoiture() {
        try{
            this.voitureDuGarage.gonflePneus(pressionReservoirAirComprime);
            pressionReservoirAirComprime -= 10;
        }catch(IllegalArgumentException e){
            System.out.println("Le message de l'exception vaut : " + e.getMessage());
            deplaceVoitureVersAtelier();
        }catch(Exception e){
            System.out.println("Truc");
        }finally{
            System.out.println("Je suis dans finally");
        }
        System.out.println("J'ai fini ma tâche");
    }

    private void deplaceVoitureVersAtelier() {
        System.out.println("La voiture est dans l'atelier");
    }

    public static void main(String[] args) {
        Garage g = new Garage();
        Voiture v = new Voiture("ma-titine");
        g.setVoitureDuGarage(v);
        g.entretienVoiture();

        v.faitUneCascade();


    }

}
