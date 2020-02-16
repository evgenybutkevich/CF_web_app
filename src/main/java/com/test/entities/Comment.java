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

    private String date;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

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

//--date
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

//--text
    public void setText(String text) {
    this.text = text;
}
    public String getText() {
        return text;
    }

//--author
    public void setAuthor(User author) {
        this.author = author;
    }
    public User getAuthor() {
        return author;
    }

}