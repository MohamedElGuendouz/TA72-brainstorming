/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.service;

import fr.utbm.TA72brainstorming.repository.EntityUserDao;
import fr.utbm.TA72brainstorming.entity.User;
/**
 *
 * @author loann
 */
public class UserService {
    public void registerUser(User u) {
        EntityUserDao eud = new EntityUserDao();
        eud.save(u);
    }
    
    public User searchUserById(long idUser) {
        EntityUserDao eud = new EntityUserDao();
        return eud.getUserById(idUser);
    }
}
