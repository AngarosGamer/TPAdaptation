package com.example.projetobserverdesignpattern;

public class Client implements Observateur {

    // Implémentation de la méthode mettreAJour
    @Override
    public void mettreAJour(String action) {
        System.out.println("Mise à jour du compte reçue par le Client : " + action);
    }
}