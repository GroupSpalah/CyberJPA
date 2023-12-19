package org.example.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.add_example.Author;
import org.example.add_example.Genre;

import java.util.List;
import java.util.stream.IntStream;

public class ManagerHelper {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        IntStream
                .rangeClosed(1, 10)
                .forEach(index -> {
                    Manager manager = Manager
                            .builder()
                            .age(32 + index)
                            .name("John" + index)
                            .build();

                    em.persist(manager);

                });


        transaction.commit();
        em.close();
        factory.close();
    }
}
