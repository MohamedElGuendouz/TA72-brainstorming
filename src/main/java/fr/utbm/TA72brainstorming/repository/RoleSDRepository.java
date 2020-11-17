/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.utbm.TA72brainstorming.entity.Role;
import fr.utbm.TA72brainstorming.entity.ERole;

/**
 *
 * @author loann
 */
@Repository
public interface RoleSDRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
}
