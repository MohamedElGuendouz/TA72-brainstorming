/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import fr.utbm.TA72brainstorming.entity.Discussion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author loann
 */
public interface DiscussionSDRepository extends CrudRepository<Discussion, Long>{
    
    Discussion findById(long id);
    
    List<Discussion> findAll();
}
