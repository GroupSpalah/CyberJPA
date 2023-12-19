package org.example.notebook;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

public class NotebookHelper {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        IntStream
                .rangeClosed(1, 10)
                .forEach(index -> {
                    Notebook notebook = Notebook
                            .builder()
                            .ssd(index + 5)
                            .ram(index + 100)
                            .model("Model" + index)
                            .date(LocalDate.now())
                            .producer("Producer" + index)
                            .build();
//                    em.persist(notebook);
                });


        transaction.commit();
        em.close();
        factory.close();
//'1', '2023-12-19', 'Model1', 'Producer1', '101', '6'
//        showByDate(LocalDate.of(2023,12,19));
//        showByRamAndSsd(101, 6);
        showByModel("Model1");
    }

    public static void showByDate(LocalDate date) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query =
                em.createQuery("FROM Notebook n WHERE n.date =: value", Notebook.class);
        query.setParameter("value", date);
        List<Notebook> notebook = query.getResultList();
        System.out.println(notebook);

        transaction.commit();
        em.close();
        factory.close();
    }

    public static void showByRamAndSsd(int ram, int ssd) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("From Notebook n WHERE n.ram =: r_value AND n.ssd =: s_value", Notebook.class);

        query.setParameter("r_value", ram);
        query.setParameter("s_value", ssd);

        List<Notebook> notebooks = query.getResultList();

        System.out.println(notebooks);

        transaction.commit();
        em.close();
        factory.close();
    }

    public static void showByModel(String model) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Notebook> query = em.createQuery("FROM Notebook n WHERE n.model =: value", Notebook.class);

        query.setParameter("value", model);

        List<Notebook> notebooks = query.getResultList();

        System.out.println(notebooks);

        transaction.commit();
        em.close();
        factory.close();
    }


}
