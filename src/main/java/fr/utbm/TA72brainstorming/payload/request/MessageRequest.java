/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.payload.request;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Loann
 */
public class MessageRequest {
    @NotBlank
    private long senderId;

    @NotBlank
    private long ReceiverId;
    
    @NotBlank
    private String time;

    @NotBlank
    private String content;

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return ReceiverId;
    }

    public void setReceiverId(long ReceiverId) {
        this.ReceiverId = ReceiverId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
