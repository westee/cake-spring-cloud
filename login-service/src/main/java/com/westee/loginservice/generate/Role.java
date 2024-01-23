package com.westee.loginservice.generate;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Role implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLES.ID
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLES.NAME
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLES.CREATED_AT
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ROLES.UPDATED_AT
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    private LocalDateTime updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ROLES
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLES
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public Role(Long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLES
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public Role() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLES.ID
     *
     * @return the value of ROLES.ID
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLES.ID
     *
     * @param id the value for ROLES.ID
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLES.NAME
     *
     * @return the value of ROLES.NAME
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLES.NAME
     *
     * @param name the value for ROLES.NAME
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLES.CREATED_AT
     *
     * @return the value of ROLES.CREATED_AT
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLES.CREATED_AT
     *
     * @param createdAt the value for ROLES.CREATED_AT
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ROLES.UPDATED_AT
     *
     * @return the value of ROLES.UPDATED_AT
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ROLES.UPDATED_AT
     *
     * @param updatedAt the value for ROLES.UPDATED_AT
     *
     * @mbg.generated Sat Jan 20 16:25:10 CST 2024
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}