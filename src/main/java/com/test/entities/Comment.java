package com.test.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private Campaign recipient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    @NotBlank(message = "Comment cannot be empty!")
    @Length(max = 1024, message = "Comment too long! (more than 1024 characters)")
    private String text;

    private String filename;
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

//--text
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

//--filename
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFilename() {
        return filename;
    }

//--dateOfCreation
    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

}