package fr.utbm.TA72brainstorming.repository;

import fr.utbm.TA72brainstorming.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUserDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("user");
    EntityManager entityManager = null;

    public void save(User f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
    }

    public User getMovieById(Long userId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, userId);
    }

    public void update(User f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(f);
        entityManager.getTransaction().commit();
    }
}
