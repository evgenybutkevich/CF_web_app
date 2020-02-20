package com.test.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Login cannot be empty!")
    @Length(max = 30, message = "Login too long! (more than 30 characters)")
    private String username;

    @NotBlank(message = "Password cannot be empty!")
    private String password;

    @Transient
    @NotBlank(message = "Password confirmation cannot be empty!")
    private String password2;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Email is not correct!")
    private String email;

    private String activationCode;
    private Date registrationDate;

    @NotBlank(message = "First name cannot be empty!")
    @Length(max = 30, message = "Login too long! (more than 30 characters)")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    @Length(max = 50, message = "Login too long! (more than 50 characters)")
    private String lastName;

    private Date birthDate;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public boolean isUser() {
        return roles.contains(Role.USER);
    }

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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

//--password
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

//--password2
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public String getPassword2() {
        return password2;
    }

//--email
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

//--activationCode
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
    public String getActivationCode() {
        return activationCode;
    }

//--registrationDate
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }

//--first_name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

//--last_name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

//--birth_date
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Date getBirthDate() {
        return birthDate;
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
        this.roles = roles;
    }
    public Set<Role> getRoles() {
        return roles;
    }

}
