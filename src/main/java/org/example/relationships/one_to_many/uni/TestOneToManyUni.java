package org.example.relationships.one_to_many.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

import java.util.List;

public class TestOneToManyUni {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Citizen citizen1 =
                Citizen
                        .builder()
                        .name("John")
                        .build();
        Citizen citizen2 =
                Citizen
                        .builder()
                        .name("Ken")
                        .build();

        House house = House
                .builder()
                .citizens(List.of(citizen1, citizen2))
                .number(10)
                .build();

//        em.persist(house);

        House house1 = em.find(House.class, 1);

        List<Citizen> citizens = house1.getCitizens();


        transaction.commit();

    }

}