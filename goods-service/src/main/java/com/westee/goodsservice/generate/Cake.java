package com.westee.goodsservice.generate;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cake implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CAKE.ID
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CAKE.NAME
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CAKE.IMG_URL
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private String imgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CAKE.DELETED
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private Boolean deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CAKE.CREATED_AT
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CAKE.UPDATED_AT
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private LocalDateTime updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table CAKE
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAKE
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public Cake(Long id, String name, String imgUrl, Boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CAKE
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public Cake() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CAKE.ID
     *
     * @return the value of CAKE.ID
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CAKE.ID
     *
     * @param id the value for CAKE.ID
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CAKE.NAME
     *
     * @return the value of CAKE.NAME
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CAKE.NAME
     *
     * @param name the value for CAKE.NAME
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CAKE.IMG_URL
     *
     * @return the value of CAKE.IMG_URL
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CAKE.IMG_URL
     *
     * @param imgUrl the value for CAKE.IMG_URL
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CAKE.DELETED
     *
     * @return the value of CAKE.DELETED
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CAKE.DELETED
     *
     * @param deleted the value for CAKE.DELETED
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CAKE.CREATED_AT
     *
     * @return the value of CAKE.CREATED_AT
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CAKE.CREATED_AT
     *
     * @param createdAt the value for CAKE.CREATED_AT
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CAKE.UPDATED_AT
     *
     * @return the value of CAKE.UPDATED_AT
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CAKE.UPDATED_AT
     *
     * @param updatedAt the value for CAKE.UPDATED_AT
     *
     * @mbg.generated Mon Jan 29 21:45:20 CST 2024
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}