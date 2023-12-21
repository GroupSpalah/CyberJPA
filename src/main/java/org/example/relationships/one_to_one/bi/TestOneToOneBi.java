package org.example.relationships.one_to_one.bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.example.relationships.one_to_one.uni.Human;
import org.example.relationships.one_to_one.uni.Phone;

public class TestOneToOneBi {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Group group = Group
                .builder()
                .name("IT")
                .age(21)
                .build();

        Praestor praestor = Praestor
                .builder()
                .group(group)
                .name("John")
                .build();

        group.setPraestor(praestor);

//        em.persist(group);

        Group group1 = em.find(Group.class, 1);

        System.out.println(group1);

        transaction.commit();

    }

}