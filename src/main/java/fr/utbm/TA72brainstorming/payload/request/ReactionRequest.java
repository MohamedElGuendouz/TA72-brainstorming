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
public class ReactionRequest {
    @NotBlank
    private long creatorId;

    @NotBlank
    private String time;

    @NotBlank
    private String type;
    
    @NotBlank
    private long PublicationId;

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPublicationId() {
        return PublicationId;
    }

    public void setPublicationId(long PublicationId) {
        this.PublicationId = PublicationId;
    }
    
}
