package com.example.edupath.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String id;
    private String name;
    private String level;
    private Double fee;
    private String description;
    private String mentor;
    private String duration;
    private boolean isFull;
    private int studentCount;
    private LocalDate startDate;
}