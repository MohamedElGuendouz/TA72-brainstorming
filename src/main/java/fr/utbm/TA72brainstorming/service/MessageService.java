/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.service;

import fr.utbm.TA72brainstorming.repository.EntityMessageDao;
import fr.utbm.TA72brainstorming.entity.Message;
/**
 *
 * @author loann
 */
public class MessageService {
    public void registerUser(Message u) {
        EntityMessageDao eud = new EntityMessageDao();
        eud.save(u);
    }
    
    public Message searchUserById(long idMsg) {
        EntityMessageDao eud = new EntityMessageDao();
        return eud.getMessageById(idMsg);
    }
}
