/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.Publication;
import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.payload.request.DiscussionRequest;
import fr.utbm.TA72brainstorming.payload.request.PublicationRequest;
import fr.utbm.TA72brainstorming.payload.response.MessageResponse;
import fr.utbm.TA72brainstorming.repository.DiscussionSDRepository;
import fr.utbm.TA72brainstorming.repository.PublicationSDRepository;
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
@RequestMapping("/api/publication")
public class PublicationController {
    @Autowired
    PublicationSDRepository psdr;
    
    @Autowired
    DiscussionSDRepository dsdr;
    
    @Autowired
    UserSDRepository usdr;
    
    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Publication getPubli(@RequestParam(value = "idPubli") long idPubli) {
        return psdr.findById(idPubli);
    }
    
    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Publication> getListPubli(@RequestParam(value = "idDisc") long idDisc) {
        Discussion dis= dsdr.findById(idDisc);
        return psdr.findAllByDiscussion(dis);
    }
    
    @PostMapping("/register")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> registerPubli(@Valid @RequestBody PublicationRequest request) {
        User creator = usdr.findById(request.getCreatorId());
        Discussion disc = dsdr.findById(request.getDiscussionId());
        Timestamp time = Timestamp.valueOf(request.getTime());
        Publication pub = new Publication(request.getContent(), time,creator,disc);
        psdr.save(pub);
        return ResponseEntity.ok(new MessageResponse("Publication registered successfully!"));
    }
}
