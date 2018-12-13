package com.khmersdeal.khmersdeal.models;

import java.sql.Timestamp;


public class Store {
    private Integer id;
    private String name;
    private String image_url;
    private String contact;
    private String website;
    private User user;
    private boolean status;
    private Timestamp createdAt;

    public Store() {
    }

    public Store(Integer id, String name, String image_url, String contact, String website, User user, boolean status, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.contact = contact;
        this.website = website;
        this.user = user;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", contact='" + contact + '\'' +
                ", website='" + website + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}