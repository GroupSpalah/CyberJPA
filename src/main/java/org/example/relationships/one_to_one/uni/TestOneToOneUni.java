package org.example.relationships.one_to_one.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

public class TestOneToOneUni {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Phone phone = Phone
                .builder()
                .number("093")
                .build();

        Human human = Human
                .builder()
                .age(21)
                .phone(phone)
                .name("Tom")
                .build();

//        em.persist(phone);
//        em.persist(human);

        Human human1 = em.find(Human.class, 1);

        em.remove(human1);

        transaction.commit();
        /*em.close();
        factory.close();*/
    }

}