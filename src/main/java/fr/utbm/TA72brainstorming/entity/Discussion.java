/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.TA72brainstorming.entity;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name = "discussions")
/**
 *
 * @author loann
 */
public class Discussion implements Serializable{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discussion")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "topic")
    private String topic;
    
    @Basic(optional = false)
    @Column(name = "creation_time")
    private Timestamp creationTime;
    
    @JoinColumn(name = "creator_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User creator;

    public Discussion(String topic, Timestamp creationTime, User creator) {
        this.topic = topic;
        this.creationTime = creationTime;
        this.creator = creator;
    }

    public Discussion(Long id, String topic, Timestamp creationTime, User creator) {
        this.id = id;
        this.topic = topic;
        this.creationTime = creationTime;
        this.creator = creator;
    }

    public Discussion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Discussion{" + "id=" + id + ", topic=" + topic + ", creationTime=" + creationTime + ", creator=" + creator + '}';
    }
}
