package com.globallogic.irribarra.dom;

import com.globallogic.irribarra.model.Phone;

/**
 * Group a single phone info
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 23, 2023
 */
public class PhoneDOM {

    private int citycode = 0;
    private String contrycode = null;
    private long number = 0L;

    /**
     * Get the phone's city code
     * 
     * @return The city code as {@code int} value
     */
    public int getCitycode() {
        return citycode;
    }

    /**
     * Get the phone's country code
     * 
     * @return A {@code String} representing the country code
     */
    public String getContrycode() {
        return contrycode;
    }

    /**
     * Get the phone's number
     * 
     * @return The phont number as {@code long} value
     */
    public long getNumber() {
        return number;
    }

    /**
     * Set the phone's city code
     * 
     * @param cityCode City code to set
     */
    public void setCitycode(final int cityCode) {
        this.citycode = cityCode;
    }

    /**
     * Set the phone's country code
     * 
     * @param contryCode Country code to set
     */
    public void setContrycode(final String contryCode) {
        this.contrycode = contryCode;
    }

    /**
     * Set the phone's number
     * 
     * @param number Phone's number to use
     */
    public void setNumber(final long number) {
        this.number = number;
    }

    public Phone toPhone() {
        Phone phone = new Phone();
        phone.setCityCode(citycode);
        phone.setCountryCode(contrycode);
        phone.setNumber(number);
        return phone;
    }
}
