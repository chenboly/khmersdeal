package com.khmersdeal.khmersdeal.models;

import java.sql.Timestamp;
import java.util.List;

public class Store {
    private Integer id;
    private String name;
    private String image_url;
    private String contact;
    private String website;
    private List<User> users;
    private boolean status;
    private Timestamp createdAt;

    public Store() {
    }

    public Store(Integer id, String name, String image_url, String contact, String website, List<User> users, boolean status, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.contact = contact;
        this.website = website;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
                ", users=" + users +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
