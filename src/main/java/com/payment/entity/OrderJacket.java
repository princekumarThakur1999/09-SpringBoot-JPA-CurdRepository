package com.payment.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;

@Entity
public class OrderJacket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //it is generate primary key value--> integer value (1....increment vale)
 //   @GeneratedValue(strategy = GenerationType.SEQUENCE)   it is generate value in the another table and insert into main table (ex. order_jacket_seq)
 //   @GeneratedValue(strategy = GenerationType.AUTO)   it is also creating another table for the seq (ex. order_jacket_seq)
 //   @GeneratedValue(strategy = GenerationType.UUID)   //it is only for String data type --> it is creating unique UUID for each row
    private Integer orderId;

    @Column
    private String jacketName;
    @Column
    private String jacketSize;

    @Column
    private String jacketPrice;

    @Column(name = "order_Date", updatable = false)
    @CreationTimestamp
    private LocalDate orderDate;

    @Column(name = "order_Price_Update", insertable = false)
    @UpdateTimestamp
    private LocalDate orderPriceUpdate;

    public OrderJacket() {
        super();
    }

    public OrderJacket(Integer orderId, String jacketName, String jacketSize, String jacketPrice, LocalDate orderDate, LocalDate orderPriceUpdate) {
        this.orderId = orderId;
        this.jacketName = jacketName;
        this.jacketSize = jacketSize;
        this.jacketPrice = jacketPrice;
        this.orderDate = orderDate;
        this.orderPriceUpdate = orderPriceUpdate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getJacketName() {
        return jacketName;
    }

    public void setJacketName(String jacketName) {
        this.jacketName = jacketName;
    }

    public String getJacketSize() {
        return jacketSize;
    }

    public void setJacketSize(String jacketSize) {
        this.jacketSize = jacketSize;
    }

    public String getJacketPrice() {
        return jacketPrice;
    }

    public void setJacketPrice(String jacketPrice) {
        this.jacketPrice = jacketPrice;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderPriceUpdate() {
        return orderPriceUpdate;
    }

    public void setOrderPriceUpdate(LocalDate orderPriceUpdate) {
        this.orderPriceUpdate = orderPriceUpdate;
    }
}
