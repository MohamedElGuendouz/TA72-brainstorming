/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import fr.utbm.TA72brainstorming.entity.Publication;
import fr.utbm.TA72brainstorming.entity.Reaction;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author loann
 */
public interface ReactionSDRepository extends CrudRepository<Reaction, Long>{
    
    Reaction findById(long id);
    
    List<Reaction> findAllByPublication(Publication pub);
}
