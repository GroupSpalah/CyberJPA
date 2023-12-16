package org.example;

import jakarta.persistence.*;

public class DeleteObjects {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query =
                em.createQuery("DELETE FROM Country c WHERE c.name =: value");

        query.setParameter("value", "UK");

        query.executeUpdate();

        transaction.commit();
        em.close();
        factory.close();
    }
}