package com.example.crv1sampleproject.repositories;

import com.example.crv1sampleproject.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Jobs extends JpaRepository<Job, Long> {

}
