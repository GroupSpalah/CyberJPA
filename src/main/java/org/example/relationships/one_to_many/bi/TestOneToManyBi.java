package org.example.relationships.one_to_many.bi;

import jakarta.persistence.*;
import lombok.Cleanup;

import java.util.List;

public class TestOneToManyBi {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
//        @Cleanup
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

//        em.persist(oak);
        /*Tree tree = em.find(Tree.class, 1);

        tree.setName("Maple");*/

//        Apple apple = tree.getApples().get(0);

        TypedQuery<Tree> query = em.createQuery("FROM Tree tr JOIN FETCH tr.apples", Tree.class);

        Tree tree = query.getSingleResult();

        transaction.commit();

        em.close();

        System.out.println(tree);

    }

}