package org.example.criteria;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.example.Country;
import org.example.Country_;

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

        Path<Integer> pathId = root.get(Country_.id);
        Path<String> pathName = root.get(Country_.name);

        query.select(root);

//        query.where(builder.equal(pathName, "UK"));// SELECT * FROM Country WHERE name = 'UK'

//        query.where(builder.equal(pathId, 2));// SELECT * FROM Country WHERE country_id = 2
        query.orderBy(builder.asc(pathName));// SELECT * FROM Country ORDER BY name

        TypedQuery<Country> emQuery = em.createQuery(query);

        List<Country> countries = emQuery.getResultList();
        System.out.println(countries);

        transaction.commit();
        em.close();
        factory.close();
    }
}