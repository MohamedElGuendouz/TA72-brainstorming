/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Message;
import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.payload.request.MessageRequest;
import fr.utbm.TA72brainstorming.payload.response.MessageResponse;
import fr.utbm.TA72brainstorming.repository.MessageSDRepository;
import fr.utbm.TA72brainstorming.repository.UserSDRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Loann
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    MessageSDRepository msdr;
    
    @Autowired
    UserSDRepository usdr;
    
    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Message> listMessage(@RequestParam(value = "idSender") long idSender,@RequestParam(value = "idReceiver") long idReceiver) {
       User sender= usdr.findById(idSender);
       User receiver = usdr.findById(idReceiver);
       //return msdr.getAllMessageBySenderAndReceiver(sender, receiver);
       return msdr.getAllMessagesByConversation(sender, receiver);
    }
    
    @GetMapping("/lastMessages")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Message> lastMessagea(@RequestParam(value = "idUser") long idUser) {
       User usr= usdr.findById(idUser);
       List<User> listU = usdr.findAllWithMessagesForUser(usr);
       List<User> listU2 = usdr.findAllWithMessagesForUserSend(usr);
       for (User usrL : listU2) {
            if(! listU.contains(usrL)) listU.add(usrL);            
       }
       List<Message> listLast= new ArrayList<Message>();
       for (User usrL : listU) {
            List<Message> listConv = msdr.getLastMessageForUsers(usr, usrL);
            if(listConv.size()>0) listLast.add(listConv.get(0));
       }
       return listLast;
    }
    
    @PostMapping("/register")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> registerMessage(@Valid @RequestBody MessageRequest request) {
        User sender = usdr.findById(request.getSenderId());
        User receiver = usdr.findById(request.getReceiverId());
        Timestamp time = Timestamp.valueOf(request.getTime());
        Message msg = new Message(request.getContent(), time,sender, receiver);
        msdr.save(msg);
        
        return ResponseEntity.ok(new MessageResponse("Message registered successfully!"));
    }
}
