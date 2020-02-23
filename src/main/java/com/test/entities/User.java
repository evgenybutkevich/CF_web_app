package com.test.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Login cannot be empty!")
    @Length(max = 30, message = "Login too long! (more than 30 characters)")
    private String username;

    @NotBlank(message = "Password cannot be empty!")
    private String password;

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

    private String sex;
    private Date birthDate;
    private String avatar;
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

    public String getStringRegistrationDate() {
        String stringDateFormat = "dd.MM.yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        String formattedDate = dateFormat.format(registrationDate);
        return formattedDate;
    }

    public String getStringBirthDate() {
        String stringDateFormat = "dd.MM.yyyy";
        DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        String formattedDate = dateFormat.format(birthDate);
        return formattedDate;
    }

//--id
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
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

//--sex
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }

//--birth_date
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Date getBirthDate() {
        return birthDate;
    }

//--avatar
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
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
