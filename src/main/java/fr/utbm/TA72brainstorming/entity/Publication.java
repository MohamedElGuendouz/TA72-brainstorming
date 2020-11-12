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
@Table(name = "publications")
/**
 *
 * @author loann
 */
public class Publication implements Serializable{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pub")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    
    @Basic(optional = false)
    @Column(name = "send_time")
    private Timestamp sendTime;
    
    @JoinColumn(name = "creator_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User creator;
    
    @JoinColumn(name = "discussion_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Discussion discussion;

    public Publication(long id, String content, Timestamp sendTime, User creator, Discussion discussion) {
        this.id = id;
        this.content = content;
        this.sendTime = sendTime;
        this.creator = creator;
        this.discussion = discussion;
    }

    public Publication(String content, Timestamp sendTime, User creator, Discussion discussion) {
        this.content = content;
        this.sendTime = sendTime;
        this.creator = creator;
        this.discussion = discussion;
    }

    public Publication() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", content=" + content + ", sendTime=" + sendTime + ", creator=" + creator + ", discussion=" + discussion + '}';
    }
}
