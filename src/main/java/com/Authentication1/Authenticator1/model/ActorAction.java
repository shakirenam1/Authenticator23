package com.Authentication1.Authenticator1.model;
import java.io.Serializable;
import java.util.Date;

public class ActorAction implements Serializable {
    private String actorEmail;
    private String action; // OWNED, IN_PROGRESS, COMPLETED, CANCELLED
    private Date actionDate;

    public ActorAction(String actorEmail, String action) {
        this.actorEmail = actorEmail;
        this.action = action;
        this.actionDate = new Date(); // Set the action date to now
    }

    public String getActorEmail() {
        return actorEmail;
    }

    public void setActorEmail(String actorEmail) {
        this.actorEmail = actorEmail;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
// Getters and Setters
}
