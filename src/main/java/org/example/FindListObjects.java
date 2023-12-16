package org.example;

import jakarta.persistence.*;

import java.util.List;

public class FindListObjects {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

//        Country country = em.find(Country.class, 1);

        TypedQuery<Country> query =
                em.createQuery("FROM Country c", Country.class);//JPQL

        List<Country> countries = query.getResultList();

        System.out.println(countries);

        transaction.commit();
        em.close();
        factory.close();
    }
}