package com.example.projetobserverdesignpattern;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class Compte {
    private double solde;
    private List<Observateur> observateurs;

    public Compte(List<Observateur> observateurs) {
        this.observateurs = observateurs;
    }

    // Faire la notification aux observateurs
    private void notifierObservateurs(String action) {
        for (Observateur observateur : observateurs) {
            observateur.mettreAJour(action);
        }
    }

    // Transaction sur le compte
    public void effectuerTransaction(double montant) {
        this.solde += montant;
        // Vérifier et notifier les observateurs en fonction de l'état
        if (this.solde < 0) {
            // Débiteur
            notifierObservateurs("Le compte est maintenant débiteur");
        } else if (this.solde > 0) {
            // Créditeur
            notifierObservateurs("Le compte est maintenant créditeur");
        } else {
            // État nul
            notifierObservateurs("Le compte est en état nul");
        }
    }

    public double getSolde() {
        return this.solde;
    }
    public void setObservateurs(List<Observateur> observateurs) {
        this.observateurs = observateurs;
    }

    public List<Observateur> getObservateurs() {
        return observateurs;
    }
}