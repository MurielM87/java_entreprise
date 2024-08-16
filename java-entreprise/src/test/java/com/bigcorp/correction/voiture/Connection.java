package com.bigcorp.correction.voiture;

public class Connection {

    public void connect(){
        System.out.println("Je suis connecté à la base");
    }

    public void disconnect(){
        System.out.println("Je ne suis plus connecté à la base");
    }

    public void nettoieTableVoiture() {
        System.out.println("Je nettoie la table voiture");
    }
}
