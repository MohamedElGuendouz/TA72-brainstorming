/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

/**
 *
 * @author loann
 */
@Entity
@Table(name = "reactions")
public class Reaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_reac")
    private Long id;
    
    @JoinColumn(name = "creator_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User creator;
    
    @JoinColumn(name = "pub_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Publication publication;
    
    @Basic(optional = false)
    @Column(name = "reaction_type")
    private String type;
    
    @Basic(optional = false)
    @Column(name = "creation_time")
    private Timestamp creationTime;

    public Reaction() {
    }

    public Reaction(Long id, User creator, Publication publication, String type, Timestamp creationTime) {
        this.id = id;
        this.creator = creator;
        this.publication = publication;
        this.type = type;
        this.creationTime = creationTime;
    }

    public Reaction(User creator, Publication publication, String type, Timestamp creationTime) {
        this.creator = creator;
        this.publication = publication;
        this.type = type;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reaction)) {
            return false;
        }
        Reaction other = (Reaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reaction{" + "id=" + id + ", creator=" + creator + ", publication=" + publication + ", type=" + type + ", creationTime=" + creationTime + '}';
    }
    
}
