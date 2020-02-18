package com.test.entities;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String topic;
    private String logo;
    private String description;
    private Double amountTotal;
    private Double amountCollected;
    private Date dateOfCreation;
    private Date dateOfUpdate;

    public Campaign() {

    }

    public Campaign(String name, String topic, String description, Double amountTotal, String logo) {
        this.name = name;
        this.topic = topic;
        this.description = description;
        this.amountTotal = amountTotal;
        this.dateOfCreation = new Date();
        this.dateOfUpdate = null;
        this.logo = logo;
    }

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

//--name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
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

}
