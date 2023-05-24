package com.globallogic.irribarra.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The {@code user} table.
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 23, 2023
 */
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private boolean active;

    @OneToMany(targetEntity = Phone.class, mappedBy = "user")
    private List<Phone> phones;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated() {
        return created;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getToken() {
        return token;
    }

    public boolean isActive() {
        return active;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public void setLastLogin(final Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public void setPhones(final List<Phone> phones) {
        this.phones = phones;
    }

}
