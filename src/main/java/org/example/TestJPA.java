package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Country canada = Country
                .builder()
                .age(31)
                .name("Canada")
                .build();//id = 0

        em.persist(canada);

        Country uk = Country
                .builder()
                .age(32)
                .name("UK")
                .build();

        em.persist(uk);

        transaction.commit();
        em.close();
        factory.close();
    }

}