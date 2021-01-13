/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.Publication;
import fr.utbm.TA72brainstorming.entity.Reaction;
import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.payload.request.PublicationRequest;
import fr.utbm.TA72brainstorming.payload.request.ReactionRequest;
import fr.utbm.TA72brainstorming.payload.response.MessageResponse;
import fr.utbm.TA72brainstorming.repository.DiscussionSDRepository;
import fr.utbm.TA72brainstorming.repository.PublicationSDRepository;
import fr.utbm.TA72brainstorming.repository.ReactionSDRepository;
import fr.utbm.TA72brainstorming.repository.UserSDRepository;
import java.sql.Timestamp;
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
@RequestMapping("/api/reaction")
public class ReactionController {
    @Autowired
    PublicationSDRepository psdr;
    
    @Autowired
    ReactionSDRepository rsdr;
    
    @Autowired
    UserSDRepository usdr;
    
    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Reaction getReac(@RequestParam(value = "idReac") long idReac) {
        return rsdr.findById(idReac);
    }
    
    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Reaction> getListReac(@RequestParam(value = "idPubli") long idPubli) {
        Publication pub= psdr.findById(idPubli);
        return rsdr.findAllByPublication(pub);
    }
    
    @PostMapping("/register")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> registerReac(@Valid @RequestBody ReactionRequest request) {
        User creator = usdr.findById(request.getCreatorId());
        Publication pub =psdr.findById(request.getPublicationId());
        Timestamp time = Timestamp.valueOf(request.getTime());
        Reaction rea = new Reaction(creator,pub,request.getType(),time);
        rsdr.save(rea);
        return ResponseEntity.ok(new MessageResponse("Reaction registered successfully!"));
    }
}
