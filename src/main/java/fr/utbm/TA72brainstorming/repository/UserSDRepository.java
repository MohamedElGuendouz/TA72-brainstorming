/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import java.util.Optional;

import fr.utbm.TA72brainstorming.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loann
 */
@Repository
public interface UserSDRepository extends JpaRepository<User, Long> {
    
    User findById(long id);
    
    List<User> findAll();
    
    Optional<User> findByUsername(String username);
    
    @Query("select m.sender from Message m where m.receiver = ?1")
    List<User> findAllWithMessagesForUser(User usr);
    
    @Query("select m.sender from Message m where m.sender = ?1")
    List<User> findAllWithMessagesForUserSend(User usr);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
