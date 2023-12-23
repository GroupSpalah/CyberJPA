package org.example.inheritance.joined;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.inheritance.single_table.ChildST1;
import org.example.inheritance.single_table.ChildST2;

public class TestJoined {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        ChildJ1 john = ChildJ1
                .builder()
                .name("John")
                .age(32)
                .salary(1000)
                .build();

        ChildJ2 jack = ChildJ2
                .builder()
                .name("Jack")
                .age(27)
                .isSecretary(true)
                .build();

        em.persist(john);
        em.persist(jack);

        transaction.commit();
        em.close();
        factory.close();
    }

}