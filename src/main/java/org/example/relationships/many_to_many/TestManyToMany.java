package org.example.relationships.many_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.example.relationships.one_to_many.bi.Apple;
import org.example.relationships.one_to_many.bi.Tree;

import java.util.List;

public class TestManyToMany {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Person john = Person
                .builder()
                .age(32)
                .name("John")
                .build();

        Person jack = Person
                .builder()
                .age(20)
                .name("Jack")
                .build();

        City kiev = City
                .builder()
                .people(List.of(john, jack))
                .name("Kiev")
                .build();

        em.persist(kiev);

        transaction.commit();

    }

}