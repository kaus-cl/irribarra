package com.globallogic.irribarra.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The {@code phone} table.
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 23, 2023
 */
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private long number;

    @Column(name = "city_code", nullable = false)
    private int cityCode;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    public int getId() {
        return id;
    }

    public long getNumber() {
        return number;
    }

    public int gtCityCode() {
        return cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setNumber(final long number){
        this.number=number;
    }

    public void setCityCode(final int cityCode) {
        this.cityCode = cityCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }
}
