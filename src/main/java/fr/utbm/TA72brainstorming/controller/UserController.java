/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.repository.UserSDRepository;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserSDRepository usdr;
    
    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public User getUser(@RequestParam(value = "idUser") long idUser) {
        return usdr.findById(idUser);
    }
    
    @GetMapping("/list")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<User> getListUser() {
        return usdr.findAll();
    }
}
