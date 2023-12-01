package com.example.projetobserverdesignpattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CompteTest {

    /* Configuration des beans */
    @Configuration
    static class CompteConfig {

        @Bean
        public Client client() { return new Client(); }
        @Bean
        public ConseillerFinancier conseiller() { return new ConseillerFinancier(); }
        @Bean
        public Compte compte(ConseillerFinancier conseiller, Client client) {
            return new Compte(List.of(conseiller, client));
        }
    }
    /* Définition des variables de test */
    private Client client = new CompteConfig().client();
    private ConseillerFinancier conseiller = new CompteConfig().conseiller();
    private Compte compte = new CompteConfig().compte(conseiller, client);

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
    /* Test vérifiant si le conseiller du compte mis à jour reçoit bien la notification appropriée */
    @Test
    void testConseillerRecuNotification() {
        compte.effectuerTransaction(10);
        assertThat(conseiller.getReceivedNotification()).isEqualTo("Le compte est maintenant créditeur");
    }

    /* Test vérifiant si le client du compte mis à jour reçoit bien la notification appropriée */
    @Test
    void testClientRecuNotification() {
        compte.effectuerTransaction(10);
        assertThat(client.getReceivedNotification()).isEqualTo("Le compte est maintenant créditeur");
    }


}
