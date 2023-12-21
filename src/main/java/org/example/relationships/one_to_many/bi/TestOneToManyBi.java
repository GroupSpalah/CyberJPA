package org.example.relationships.one_to_many.bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

import java.util.List;

public class TestOneToManyBi {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Apple apple1 = Apple
                .builder()
                .size(10)
                .build();

        Apple apple2 = Apple
                .builder()
                .size(15)
                .build();

        Tree oak = Tree
                .builder()
                .name("Oak")
                .apples(List.of(apple1, apple2))
                .build();

        apple1.setTree(oak);
        apple2.setTree(oak);

        em.persist(oak);

        transaction.commit();

    }

}