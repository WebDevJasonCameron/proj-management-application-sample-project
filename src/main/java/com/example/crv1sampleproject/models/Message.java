package com.example.crv1sampleproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
    @Column(name = "time_stamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;

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
