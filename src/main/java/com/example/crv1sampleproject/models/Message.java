package com.example.crv1sampleproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "comment", length = 2000)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Job job;

    // CON
    public Message() {
    }

    // GET
    public long getId() {
        return id;
    }
    public String getComment() {
        return comment;
    }
    public Job getJob() {
        return job;
    }

    // SET
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setJob(Job job) {
        this.job = job;
    }


    // CHECK
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }


}  //  <--END
