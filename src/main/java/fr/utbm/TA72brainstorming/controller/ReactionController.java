/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.Publication;
import fr.utbm.TA72brainstorming.entity.Reaction;
import fr.utbm.TA72brainstorming.repository.DiscussionSDRepository;
import fr.utbm.TA72brainstorming.repository.PublicationSDRepository;
import fr.utbm.TA72brainstorming.repository.ReactionSDRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Loann
 */
@RestController
@RequestMapping("/api/reaction")
public class ReactionController {
    @Autowired
    PublicationSDRepository psdr;
    
    @Autowired
    ReactionSDRepository rsdr;
    
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
}
