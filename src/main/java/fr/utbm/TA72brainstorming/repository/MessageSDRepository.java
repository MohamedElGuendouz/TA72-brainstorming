/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import fr.utbm.TA72brainstorming.entity.Message;
import fr.utbm.TA72brainstorming.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author loann
 */
public interface MessageSDRepository extends CrudRepository<Message, Long>{
    
    Message findById(long id);
    
    List<Message> getAllMessageBySenderAndReceiver(User sender, User receiver);
    
    @Query("from Message m where (m.sender = ?1 and m.receiver = ?2) or (m.sender = ?2 and m.receiver=?1) order by sendTime")
    List<Message> getAllMessagesByConversation(User sender, User Receiver);
    
    @Query("from Message m where (m.sender = ?1 and m.receiver = ?2) or (m.sender = ?2 and m.receiver=?1) order by sendTime DESC")
    List<Message> getLastMessageForUsers(User usr, User usr2);
}
