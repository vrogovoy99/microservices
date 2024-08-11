package org.vr.quizes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<Long> questionIds;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
