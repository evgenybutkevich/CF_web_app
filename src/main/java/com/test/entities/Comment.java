package com.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Comment() {
    }

    public Comment(String text, User user) {
        this.text = text;
        this.author = user;
    }

    public String getAuthorName() {
        return author.getUsername();
    }

//--id
    public void setId(Integer id) {
    this.id = id;
}
    public Integer getId() {
        return id;
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