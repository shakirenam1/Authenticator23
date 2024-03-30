package com.Authentication1.Authenticator1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class ServiceRequest implements Serializable {

    @Id
    private String id;
    private String serviceType;
    private Date serviceCreationDate;
    private String serviceInfo;
    private String status; // NEW, CLAIMED, IN_PROGRESS, COMPLETE, CANCELLED
    private Double paymentAmount;
    private String creatorEmail;
    private String creatorPhone;
    private List<ActorAction> actorActions = new ArrayList<>();

    // Getters, Setters, and existing methods
    public void addActorAction(ActorAction action) {
        this.actorActions.add(action);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getServiceCreationDate() {
        return serviceCreationDate;
    }

    public void setServiceCreationDate(Date serviceCreationDate) {
        this.serviceCreationDate = serviceCreationDate;
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public String getCreatorPhone() {
        return creatorPhone;
    }

    public void setCreatorPhone(String creatorPhone) {
        this.creatorPhone = creatorPhone;
    }


    // Constructors, Getters, and Setters
}
