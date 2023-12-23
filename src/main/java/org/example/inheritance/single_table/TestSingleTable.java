package org.example.inheritance.single_table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.inheritance.mapped_super_class.ChildMSC1;
import org.example.inheritance.mapped_super_class.ChildMSC2;

public class TestSingleTable {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        ChildST1 st1 = ChildST1
                .builder()
                .name("John")
                .st1Name("Travolta")
                .build();

        ChildST2 st2 = ChildST2
                .builder()
                .name("Jack")
                .st2Name("Kennedi")
                .build();

        em.persist(st1);
        em.persist(st2);

        transaction.commit();
        em.close();
        factory.close();
    }

}