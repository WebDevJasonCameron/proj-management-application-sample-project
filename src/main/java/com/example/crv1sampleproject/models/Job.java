package com.example.crv1sampleproject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "details")
    private String details;
    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", orphanRemoval = true)
    @JsonManagedReference
    private List<Message> messages;

    // CON
    public Job() {
    }

    // GET
    public long getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public String getDetails() {
        return details;
    }
    public String getTitle() {
        return title;
    }

    // SET
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // CHECK
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                ", messages=" + messages +
                '}';
    }



}  //<--END
