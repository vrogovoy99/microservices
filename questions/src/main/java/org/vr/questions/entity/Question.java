package org.vr.questions.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String response1;
    private String response2;
    private String response3;
    private String response4;
    private String correctResponse;
    private String subject;
    private Integer complexity;
}
