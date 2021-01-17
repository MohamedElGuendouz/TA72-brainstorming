/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.controller;

import fr.utbm.TA72brainstorming.entity.Discussion;
import fr.utbm.TA72brainstorming.entity.ERole;
import fr.utbm.TA72brainstorming.entity.Role;
import fr.utbm.TA72brainstorming.entity.User;
import fr.utbm.TA72brainstorming.payload.request.UpdateUser;
import fr.utbm.TA72brainstorming.payload.response.MessageResponse;
import fr.utbm.TA72brainstorming.repository.RoleSDRepository;
import fr.utbm.TA72brainstorming.repository.UserSDRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserSDRepository usdr;
    
    @Autowired
    RoleSDRepository roleRepository;
    
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
    
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> UpdateUser(@Valid @RequestBody UpdateUser request) {
        User usr = usdr.findById(request.getId());
        usr.setEmail(request.getEmail());
        usr.setUsername(request.getUsername());
        usr.setFirstname(request.getFirstName());
        usr.setLastname(request.getLastName());
        Set<Role> roles = new HashSet<>();
        request.getRole().forEach(role -> {
            switch (role) {
            case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);

                    break;
            case "mod":
                    Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);

                    break;
            default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });
        usr.setRoles(roles);
        usdr.save(usr);
        
        return ResponseEntity.ok(new MessageResponse("Message updated successfully!"));
    }
}
