package com.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
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

}