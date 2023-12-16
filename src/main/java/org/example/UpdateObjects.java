package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateObjects {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("test_jpa");

    public static void main(String[] args) {

        EntityManager em = FACTORY.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Country usa = em.find(Country.class, 2);//id != 0

        Country usa1 = em.find(Country.class, 2);//id != 0

//        usa.setName("USA");//change Ireland to USA

//        em.persist(usa);

        update(usa);

        transaction.commit();
        em.close();
    }

    public static void update(Country country) {//country with id != 0
        EntityManager em1 = FACTORY.createEntityManager();

        EntityTransaction transaction = em1.getTransaction();
        transaction.begin();

        country.setName("Ireland");//change USA to Ireland

        Country country1 = em1.merge(country);

        em1.persist(country1);

        transaction.commit();
        em1.close();
    }

    public static void save(Country country) {
        EntityManager em1 = FACTORY.createEntityManager();

        EntityTransaction transaction = em1.getTransaction();
        transaction.begin();

        em1.persist(country);

        transaction.commit();
        em1.close();
    }
}