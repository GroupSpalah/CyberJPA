package org.example;

import jakarta.persistence.*;

public class FindObjects {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

//        Country country = em.find(Country.class, 1);

        TypedQuery<Country> query =
                em.createQuery("FROM Country c WHERE c.name =: value", Country.class);//JPQL

        query.setParameter("value", "Canada");

        Country country = query.getSingleResult();

        System.out.println(country);

        transaction.commit();
        em.close();
        factory.close();
    }
}