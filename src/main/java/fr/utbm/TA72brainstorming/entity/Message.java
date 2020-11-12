package fr.utbm.TA72brainstorming.entity;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name = "messages")

public class Message implements Serializable
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_msg")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    
    @Basic(optional = false)
    @Column(name = "send_time")
    private Timestamp sendTime;
    
    @JoinColumn(name = "sender_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;
    
    @JoinColumn(name = "receiver_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User receiver;

    public Message(String content, Timestamp sendTime, User sender, User receiver) {
        this.content = content;
        this.sendTime = sendTime;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(long id) {
        this.id = id;
    }

    public Message() {
    }

    public Message(long id, String content, Timestamp sendTime, User sender, User receiver) {
        this.id = id;
        this.content = content;
        this.sendTime = sendTime;
        this.sender = sender;
        this.receiver = receiver;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", content=" + content + ", sendTime=" + sendTime + ", sender=" + sender + ", receiver=" + receiver + '}';
    }
}