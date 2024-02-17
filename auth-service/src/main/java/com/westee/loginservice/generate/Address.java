package com.westee.loginservice.generate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Address implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.ID
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.USER_ID
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.CONTACT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private String contact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.NAME
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.LATITUDE
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private BigDecimal latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.LONGITUDE
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private BigDecimal longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.PHONE_NUMBER
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private String phoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.DEFAULT_ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private Boolean defaultAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.SPECIFIC_ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private String specificAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.GENDER
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private Byte gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.DELETED
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private Integer deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.CREATED_AT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ADDRESS.UPDATED_AT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private LocalDateTime updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Address(Long id, Long userId, String contact, String address, String name, BigDecimal latitude, BigDecimal longitude, String phoneNumber, Boolean defaultAddress, String specificAddress, Byte gender, Integer deleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.contact = contact;
        this.address = address;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.defaultAddress = defaultAddress;
        this.specificAddress = specificAddress;
        this.gender = gender;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Address() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.ID
     *
     * @return the value of ADDRESS.ID
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.ID
     *
     * @param id the value for ADDRESS.ID
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.USER_ID
     *
     * @return the value of ADDRESS.USER_ID
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.USER_ID
     *
     * @param userId the value for ADDRESS.USER_ID
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.CONTACT
     *
     * @return the value of ADDRESS.CONTACT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.CONTACT
     *
     * @param contact the value for ADDRESS.CONTACT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.ADDRESS
     *
     * @return the value of ADDRESS.ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.ADDRESS
     *
     * @param address the value for ADDRESS.ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.NAME
     *
     * @return the value of ADDRESS.NAME
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.NAME
     *
     * @param name the value for ADDRESS.NAME
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.LATITUDE
     *
     * @return the value of ADDRESS.LATITUDE
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.LATITUDE
     *
     * @param latitude the value for ADDRESS.LATITUDE
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.LONGITUDE
     *
     * @return the value of ADDRESS.LONGITUDE
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.LONGITUDE
     *
     * @param longitude the value for ADDRESS.LONGITUDE
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.PHONE_NUMBER
     *
     * @return the value of ADDRESS.PHONE_NUMBER
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.PHONE_NUMBER
     *
     * @param phoneNumber the value for ADDRESS.PHONE_NUMBER
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.DEFAULT_ADDRESS
     *
     * @return the value of ADDRESS.DEFAULT_ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.DEFAULT_ADDRESS
     *
     * @param defaultAddress the value for ADDRESS.DEFAULT_ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.SPECIFIC_ADDRESS
     *
     * @return the value of ADDRESS.SPECIFIC_ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public String getSpecificAddress() {
        return specificAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.SPECIFIC_ADDRESS
     *
     * @param specificAddress the value for ADDRESS.SPECIFIC_ADDRESS
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setSpecificAddress(String specificAddress) {
        this.specificAddress = specificAddress == null ? null : specificAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.GENDER
     *
     * @return the value of ADDRESS.GENDER
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.GENDER
     *
     * @param gender the value for ADDRESS.GENDER
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.DELETED
     *
     * @return the value of ADDRESS.DELETED
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.DELETED
     *
     * @param deleted the value for ADDRESS.DELETED
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.CREATED_AT
     *
     * @return the value of ADDRESS.CREATED_AT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.CREATED_AT
     *
     * @param createdAt the value for ADDRESS.CREATED_AT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ADDRESS.UPDATED_AT
     *
     * @return the value of ADDRESS.UPDATED_AT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ADDRESS.UPDATED_AT
     *
     * @param updatedAt the value for ADDRESS.UPDATED_AT
     *
     * @mbg.generated Thu Jan 25 11:05:11 CST 2024
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}