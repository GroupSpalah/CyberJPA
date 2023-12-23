package org.example.inheritance.mapped_super_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.Country;

public class TestMSC {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        ChildMSC1 msc1 = ChildMSC1
                .builder()
                .name("John")
                .firstName("Travolta")
                .build();

        ChildMSC2 msc2 = ChildMSC2
                .builder()
                .name("Ben")
                .lastName("Adam")
                .build();

        em.persist(msc1);
        em.persist(msc2);

        transaction.commit();
        em.close();
        factory.close();
    }

}