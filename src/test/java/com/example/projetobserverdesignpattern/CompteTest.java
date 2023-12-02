package com.example.projetobserverdesignpattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CompteTest {

    @Configuration
    static class CompteConfig {

    }
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Compte compte = (Compte) context.getBean("compte");

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
    /* Test vérifiant si le premier observateur du compte mis à jour reçoit bien la notification appropriée */
    @Test
    void testConseillerRecuNotification() {
        compte.effectuerTransaction(10);
        assertThat(compte.getObservateurs().get(0).getReceivedNotification()).isEqualTo("Le compte est maintenant créditeur");
    }

    /* Test vérifiant si le deuxième observateur du compte mis à jour reçoit bien la notification appropriée */
    @Test
    void testClientRecuNotification() {
        compte.effectuerTransaction(10);
        assertThat(compte.getObservateurs().get(1).getReceivedNotification()).isEqualTo("Le compte est maintenant créditeur");
    }


}
