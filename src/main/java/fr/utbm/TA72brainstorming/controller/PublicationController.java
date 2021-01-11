/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.Publication;
import fr.utbm.TA72brainstorming.repository.DiscussionSDRepository;
import fr.utbm.TA72brainstorming.repository.PublicationSDRepository;
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
@RequestMapping("/api/publication")
public class PublicationController {
    @Autowired
    PublicationSDRepository psdr;
    
    @Autowired
    DiscussionSDRepository dsdr;
    
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
}
