package com.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String topicName;

//--id
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

//--topicName
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    public String getTopicName() {
        return topicName;
    }

}
