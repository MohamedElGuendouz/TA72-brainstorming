package fr.utbm.TA72brainstorming.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "users")

public class User implements Serializable

{
    public User(){
    }
    
    public User(long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private long id;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;
	
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
	
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstname;
    
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastname;
    
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
	
}