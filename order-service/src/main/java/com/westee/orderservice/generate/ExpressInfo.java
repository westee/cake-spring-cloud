package com.westee.orderservice.generate;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExpressInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPRESS_INFO.ID
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPRESS_INFO.ORDER_ID
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPRESS_INFO.WX_ORDER_NO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private String wxOrderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPRESS_INFO.INFO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private String info;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPRESS_INFO.CREATED_AT
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPRESS_INFO.UPDATED_AT
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private LocalDateTime updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table EXPRESS_INFO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EXPRESS_INFO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public ExpressInfo(Long id, Long orderId, String wxOrderNo, String info, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.orderId = orderId;
        this.wxOrderNo = wxOrderNo;
        this.info = info;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EXPRESS_INFO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public ExpressInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPRESS_INFO.ID
     *
     * @return the value of EXPRESS_INFO.ID
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPRESS_INFO.ID
     *
     * @param id the value for EXPRESS_INFO.ID
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPRESS_INFO.ORDER_ID
     *
     * @return the value of EXPRESS_INFO.ORDER_ID
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPRESS_INFO.ORDER_ID
     *
     * @param orderId the value for EXPRESS_INFO.ORDER_ID
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPRESS_INFO.WX_ORDER_NO
     *
     * @return the value of EXPRESS_INFO.WX_ORDER_NO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public String getWxOrderNo() {
        return wxOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPRESS_INFO.WX_ORDER_NO
     *
     * @param wxOrderNo the value for EXPRESS_INFO.WX_ORDER_NO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public void setWxOrderNo(String wxOrderNo) {
        this.wxOrderNo = wxOrderNo == null ? null : wxOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPRESS_INFO.INFO
     *
     * @return the value of EXPRESS_INFO.INFO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPRESS_INFO.INFO
     *
     * @param info the value for EXPRESS_INFO.INFO
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPRESS_INFO.CREATED_AT
     *
     * @return the value of EXPRESS_INFO.CREATED_AT
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPRESS_INFO.CREATED_AT
     *
     * @param createdAt the value for EXPRESS_INFO.CREATED_AT
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPRESS_INFO.UPDATED_AT
     *
     * @return the value of EXPRESS_INFO.UPDATED_AT
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPRESS_INFO.UPDATED_AT
     *
     * @param updatedAt the value for EXPRESS_INFO.UPDATED_AT
     *
     * @mbg.generated Thu Mar 07 21:05:33 CST 2024
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}