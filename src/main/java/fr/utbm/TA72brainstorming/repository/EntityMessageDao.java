/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import fr.utbm.TA72brainstorming.entity.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author loann
 */
public class EntityMessageDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("user");
    EntityManager entityManager = null;

    public void save(Message f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
    }

    public Message getMessageById(long msgId) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Message.class, msgId);
    }

    public void update(Message f) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(f);
        entityManager.getTransaction().commit();
    }
}
