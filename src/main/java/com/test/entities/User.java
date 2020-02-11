package com.test.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

//--id
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

//--username
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

//--password
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

//--active
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean isActive() {
        return active;
    }

//--role
    public void setRoles(Set<Role> roles) {
        this.role = role;
    }
    public Set<Role> getRoles() {
        return role;
    }

}
