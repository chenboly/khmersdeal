package com.khmersdeal.khmersdeal.models;

import java.sql.Timestamp;
import java.util.List;

public class User {
    private Integer id;
    private String fullname;
    private String username;
    private String password;
    private String image_url;
    private String phone;
    private String email;
    private List<Store> stores;
    private boolean status;
    private boolean activeStatus;
    private Timestamp createdAt;

    public User() {
    }

    public User(Integer id, String fullname, String username, String password, String image_url, String phone, String email, List<Store> stores, boolean status, boolean activeStatus, Timestamp createdAt) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.image_url = image_url;
        this.phone = phone;
        this.email = email;
        this.stores = stores;
        this.status = status;
        this.activeStatus = activeStatus;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullname='" + fullname + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", image_url='" + image_url + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + ", stores=" + stores + ", status=" + status + ", activeStatus=" + activeStatus + ", createdAt=" + createdAt + '}';
    }
}
