/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import fr.utbm.TA72brainstorming.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author loann
 */
public interface UserSDRepository extends CrudRepository<User, Long> {
    
    User findById(long id);
}
