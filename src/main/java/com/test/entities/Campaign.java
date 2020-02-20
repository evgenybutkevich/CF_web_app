package com.test.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @NotBlank(message = "Campaign name cannot be empty!")
    @Length(max = 255, message = "Campaign name too long! (more than 255 characters)")
    private String campaignName;

    private String topic;

//    tags

    private String logo;

    @NotBlank(message = "Description cannot be empty!")
    @Length(max = 1024, message = "Description too long! (more than 1024 characters)")
    private String description;

//    images
//    videos

    private Double amountTotal;

    private Double amountCollected;

//    bonuses

    private Date dateOfCreation;
    private Date dateOfUpdate;
    private Date dateOfExpiry;

    public String getStringDateOfCreation() {
        String stringDateFormat = "dd.MM.yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        String formattedDate = dateFormat.format(dateOfCreation);
        return formattedDate;
    }

    public String getStringDateOfUpdate() {
        if (dateOfUpdate != null) {
            String stringDateFormat = "dd.MM.yyyy HH:mm:ss";
            DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
            String formattedDate = dateFormat.format(dateOfUpdate);
            return formattedDate;
        } else {
            return "There were no updates";
        }
    }

//--id
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

//--author
    public void setAuthor(User author) {
        this.author = author;
    }
    public User getAuthor() {
        return author;
    }

//--campaignName
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
    public String getCampaignName() {
        return campaignName;
    }

//--topic
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getTopic() {
        return topic;
    }

//--logo
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getLogo() {
        return logo;
    }

//--description
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

//--amountTotal
    public void setAmountTotal(Double amountTotal) {
        this.amountTotal = amountTotal;
    }
    public Double getAmountTotal() {
        return amountTotal;
    }

//--amountCollected
    public void setAmountCollected(Double amountCollected) {
        this.amountCollected = amountCollected;
    }
    public Double getAmountCollected() {
        return amountCollected;
    }

//--dateOfCreation
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

//--dateOfUpdate
    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }
    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

//--dateOfExpiry
    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

}
