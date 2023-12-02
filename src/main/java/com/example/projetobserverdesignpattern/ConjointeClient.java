package com.example.projetobserverdesignpattern;

public class ConjointeClient implements Observateur {

    private String notification;

    // Implémentation de la méthode mettreAJour
    @Override
    public void mettreAJour(String action) {
        this.notification = action;
        System.out.println("Mise à jour du compte reçue par la Conjointe du Client : " + action);
    }

    @Override
    public String getReceivedNotification() {
        return this.notification;
    }
}

