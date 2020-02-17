package com.test.entities;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String text;
    private String filename;
    private String date;

    public Comment() {
    }

    public Comment(String text, User user) {
        this.date = getStringDate();
        this.text = text;
        this.author = user;
    }

    public String getAuthorName() {
        return author.getUsername();
    }

    public String getStringDate() {
        Date date = new Date();
        String stringDateFormat = "dd.MM.yyyy HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        String formattedDate = dateFormat.format(date);
        return formattedDate;
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

//--date
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

}