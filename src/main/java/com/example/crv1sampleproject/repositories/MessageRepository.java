package com.example.crv1sampleproject.repositories;

import com.example.crv1sampleproject.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
