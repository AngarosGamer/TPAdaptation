package com.example.projetobserverdesignpattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Compte compte = (Compte) context.getBean("compte");
        compte.effectuerTransaction(1000);
        compte.effectuerTransaction(-1200);
        compte.effectuerTransaction(200);
    }
}