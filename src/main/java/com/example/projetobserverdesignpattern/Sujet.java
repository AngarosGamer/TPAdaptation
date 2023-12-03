package com.example.projetobserverdesignpattern;

import java.util.List;

public interface Sujet {

    List<Observateur> observateurs = null;

    public void ajouterObservateur(Observateur observateur);

    public void supprimerObservateur(Observateur observateur);

    private void notifierObservateurs(String action) {

    }

    public List<Observateur> getObservateurs();
}
