package com.example.projetobserverdesignpattern;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class Compte implements Sujet {
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

    @Override
    public void ajouterObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }
    @Override
    public void supprimerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }

    public List<Observateur> getObservateurs() {
        return observateurs;
    }


}