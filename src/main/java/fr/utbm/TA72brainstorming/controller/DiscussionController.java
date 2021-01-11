/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.Message;
import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.payload.request.DiscussionRequest;
import fr.utbm.TA72brainstorming.payload.request.MessageRequest;
import fr.utbm.TA72brainstorming.payload.response.MessageResponse;
import fr.utbm.TA72brainstorming.repository.DiscussionSDRepository;
import fr.utbm.TA72brainstorming.repository.UserSDRepository;
import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RestController
@RequestMapping("/api/discussion")
public class DiscussionController {
    @Autowired
    DiscussionSDRepository dsdr;
    
    @Autowired
    UserSDRepository usdr;
    
    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Discussion getDisc(@RequestParam(value = "idDisc") long idDisc) {
        return dsdr.findById(idDisc);
    }
    
    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Discussion> getListDisc() {
        return dsdr.findAll();
    }
    
    @GetMapping("/search")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Discussion> getListSearchDisc(@RequestParam(value = "topic") String chaine) {
        return dsdr.findAllByTopicContaining(chaine);
    }
    
    @PostMapping("/register")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> registerMessage(@Valid @RequestBody DiscussionRequest request) {
        User creator = usdr.findById(request.getCreatorId());
        Timestamp time = Timestamp.valueOf(request.getTime());
        Discussion dis = new Discussion(request.getTopic(), time,creator);
        dsdr.save(dis);
        return ResponseEntity.ok(new MessageResponse("Discussion registered successfully!"));
    }
}
