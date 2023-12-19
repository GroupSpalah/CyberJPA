package org.example.criteria;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.example.Country;

import java.util.List;

public class FindListObjectCriteria {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Country> query = builder.createQuery(Country.class);

        Root<Country> root = query.from(Country.class);

        query.select(root);

        TypedQuery<Country> emQuery = em.createQuery(query);

        System.out.println(emQuery.getResultList());

        transaction.commit();
        em.close();
        factory.close();
    }
}