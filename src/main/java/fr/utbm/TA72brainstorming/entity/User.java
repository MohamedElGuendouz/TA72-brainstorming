package fr.utbm.TA72brainstorming.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")

public class User implements Serializable

{
    public User(){
    }
    
    public User(long id){
        this.id = id;
    }

    public User(String username, String password, String email, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
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
    @Column(name = "email")
    private String email;
	
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", first name=" + firstname + ", lastname=" + lastname + '}';
    }
}