package com.ajibigad.corperwee.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Julius on 23/02/2016.
 */
@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;
    private String website;
    private String email;
    //this needs to be read only, a trigger in mysql would update it
    private int rating;
    private String state;
    private String lga;
    private String town;
    private String direction;
    private String phoneNumber;

    @Value("#{T(System).currentTimeMillis()}")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @ManyToOne(cascade = CascadeType.MERGE)
    // this is because we add the user at the time of creation in the controller. The user we add is detached from the session so when it trys saving --> ERROR!!! This would make it just merge and save it
    @JoinColumn(name = "addedBy")
    //@JsonIgnore we need to know who added this place
    private User addedBy;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

//    public void setRating(int rating) {
//        this.rating = rating;
//    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
