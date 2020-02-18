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

    private Integer path;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String text;
    private String filename;
    private Date date;

    public Comment() {
    }

    public Comment(Integer path, User user, String text) {
        this.path = path;
        this.author = user;
        this.text = text;
        this.date = new Date();
    }

    public String getAuthorName() {
        return author.getUsername();
    }

    public String getStringDate() {
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

//--path
    public void setPath(Integer path) {
        this.path = path;
    }
    public Integer getPath() {
        return path;
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
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

}