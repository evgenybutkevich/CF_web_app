package com.test.entities;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private Campaign recipient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    private Double amount;
    private Date dateOfCreation;

    public Long getAuthorId() {
        return author.getId();
    }

    public String getAuthorName() {
        return author.getFirstName();
    }

    public String getAuthorAvatar() {
        return author.getAvatar();
    }

    public String getStringDateOfCreation() {
        String stringDateFormat = "dd.MM.yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        String formattedDate = dateFormat.format(dateOfCreation);
        return formattedDate;
    }

//--id
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

//--recipient
    public void setRecipient(Campaign recipient) {
        this.recipient = recipient;
    }
    public Campaign getRecipient() {
        return recipient;
    }

//--author
    public void setAuthor(User author) {
        this.author = author;
    }
    public User getAuthor() {
        return author;
    }

//--amount
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Double getAmount() {
        return amount;
    }

//--dateOfCreation
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

}
