package com.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "campaings")
public class Campaing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String topic;
    private String logo;
    private String description;
    private Double amountTotal;
    private Double amountCollected;

    public Campaing() {

    }

    public Campaing(String name, String topic, String description, Double amountTotal, String logo) {
        this.name = name;
        this.topic = topic;
        this.description = description;
        this.amountTotal = amountTotal;
        this.logo = logo;
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

}
