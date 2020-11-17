package fr.utbm.TA72brainstorming.entity;

import javax.persistence.*;
import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")

public class User implements Serializable

{
    public User(){
    }
    
    public User(Long id){
        this.id = id;
    }

    public User(String username, String email, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Long id;

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
    @Column(name = "first_name", nullable=true)
    private String firstname;
    
    @Basic(optional = false)
    @Column(name = "last_name", nullable=true)
    private String lastname;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", first name=" + firstname + ", lastname=" + lastname + '}';
    }
}