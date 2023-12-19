package org.example.add_example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.Country;

import java.util.stream.IntStream;

public class AuthorHelper {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        IntStream
                .rangeClosed(1, 200)
                .forEach(index -> {
                    Author author = Author
                            .builder()
                            .genre(Genre.MELODRAMA)
                            .name("John" + index)
                            .build();
                    em.persist(author);
                });


        transaction.commit();
        em.close();
        factory.close();
    }
}
