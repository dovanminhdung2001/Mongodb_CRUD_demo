package com.example.mongodb_curd_demo2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String _id;
    private boolean activated;
    private String password;
    private String userName;

    public User() {
    }

    public User( boolean activated, String userName, String password) {
         this.activated = activated;
        this.userName = userName;
        this.password = password;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", activated=" + activated +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
