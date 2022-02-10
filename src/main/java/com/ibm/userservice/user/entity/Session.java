package com.ibm.userservice.user.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    @OneToOne
    private User user;

    private boolean sessionType;
    private Date session_date;

    public Session(Long session_id, User user, boolean sessionType){
        this.session_id = session_id;
        this.user = user;
        this.sessionType = sessionType;
        this.session_date = new Date();
    }

    public Session() {

    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isSessionType() {
        return sessionType;
    }

    public void setSessionType(boolean sessionType) {
        this.sessionType = sessionType;
    }

    public Date getSession_date() {
        return session_date;
    }

    public void setSession_date(Date session_date) {
        this.session_date = session_date;
    }
}
