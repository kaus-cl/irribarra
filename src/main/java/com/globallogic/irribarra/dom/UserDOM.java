package com.globallogic.irribarra.dom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.globallogic.irribarra.model.Phone;
import com.globallogic.irribarra.model.User;

/**
 * Encapsulate all the info for an user
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 23, 2023
 */
public class UserDOM {

    @NotNull(message = "E-Mail is required")
    @Email(message = "Wrong Email format")
    private String email = null;

    private String name = null;

    @NotNull(message = "Password is required")
    @Pattern(regexp = "^[a-z]*[A-Z][a-z]*\\d[a-z]*\\d[a-z]*|[a-z]*\\d[a-z]*[A-Z][a-z]*\\d[a-z]*|[a-z]*\\d[a-z]*\\d[a-z]*[A-Z][a-z]*$", message = "Wrong password format")
    @Size(min = 8, max = 12, message = "Password should have between 8 and 12 characters")
    private String password = null;

    private List<PhoneDOM> phones = null;

    /**
     * Get the user's email
     * 
     * @return The user's email as {@code String}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the user's name
     * 
     * @return The user's name as {@code String}
     */
    public String getName() {
        return name;
    }

    /**
     * Get the user's password (encrypted)
     * 
     * @return The encrypted user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the list of phones for this user
     * 
     * @return A {@code List} of {@code Phone} objects. Could be {@code null}.
     */
    public List<PhoneDOM> getPhones() {
        return phones;
    }

    /**
     * Set the user's email
     * 
     * @param email Email to set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Set the user full name
     * 
     * @param name Name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Set the user's password.
     * 
     * @param password Value to use, encoded or not
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Set the user's phone list.
     * 
     * @param phones Phone list.
     */
    public void setPhones(final List<PhoneDOM> phones) {
        this.phones = phones;
    }

    public User toUser() {
        User user = new User();
        user.setActive(true);
        user.setCreated(new Date());
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        if (phones != null && phones.size() > 0) {
            List<Phone> phoneList = new ArrayList<>();
            phones.stream().forEach((p) -> {
                phoneList.add(p.toPhone());
            });
            user.setPhones(phoneList);
        }
        return user;
    }
}
