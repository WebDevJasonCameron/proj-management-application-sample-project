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

    // SET
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    // CHECK
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", messages=" + messages +
                '}';
    }

}  //<--END
