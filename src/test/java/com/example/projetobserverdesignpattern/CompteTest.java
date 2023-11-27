package com.example.projetobserverdesignpattern;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CompteTest {

    /* Configuration du bean */
    @Configuration
    static class CompteConfig {
        @Bean
        public Compte compte() {
            return new Compte(List.of(new ConseillerFinancier()));
        }
    }
    private Compte compte = new CompteConfig().compte();

    /* Test de l'ajout d'un solde négatif
       On vérifie si la mise à jour du solde fonctionne, et on peut ensuite vérifier si le message
       s'affiche bien pour le conseiller financier.
     */
    @Test
    void testEffectuerTransactionSoldeNegatif() {
        compte.effectuerTransaction(-500);
        assertThat(compte.getSolde()).isEqualTo(-500);
    }
    /* Test de l'ajout d'un solde positif
       On vérifie si la mise à jour du solde fonctionne, et on peut ensuite vérifier si le message
       s'affiche bien pour le conseiller financier.
    */
    @Test
    void testEffectuerTransactionSoldePositif() {
        compte.effectuerTransaction(800);
        assertThat(compte.getSolde()).isEqualTo(800);
    }
    /* Test de l'ajout d'un solde positif
    On vérifie si la mise à jour du solde fonctionne, et on peut ensuite vérifier si le message
    s'affiche bien pour le conseiller financier.
    */
    @Test
    void TestSoldeNul() {
        compte.effectuerTransaction(0);
        assertThat(compte.getSolde()).isEqualTo(0);
    }

}
