package org.example.manager;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.IntStream;

public class ManagerHelperRecord {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Manager> query = em.createQuery("FROM Manager", Manager.class);

        List<RManager> managers = query
                .getResultStream()
                .map(m -> new RManager(m.getName(), m.getAge()))
                .toList();

        System.out.println(managers);

        transaction.commit();
        em.close();
        factory.close();
    }
}
