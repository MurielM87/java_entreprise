package com.bigcorp.correction.voiture;

/**
 * Modélise une voiture pour revente,
 * développée en TDD à partir de VoiturePourReventeTest
 */
public class VoiturePourRevente {

    private int prixAchat;

    private int kilometrage;

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getValeurRevente() {
        if(this.kilometrage < 10000){
            return this.prixAchat;
        }else{
            return this.prixAchat - (this.kilometrage - 10000);
        }
    }
}
