package com.example.projetobserverdesignpattern;

// Interface Observateur
public interface Observateur {
    String notification = null;
    void mettreAJour(String action);
    String getReceivedNotification();
}