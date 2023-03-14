package com.example.web4.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "shots")
public class Shot {
    @Id
    @SequenceGenerator(name = "shots_id_seq", sequenceName = "shots_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shots_id_seq")
    private long id;
    private boolean hitvalue;
    private double x;
    private double y;
    private double r;
    private Date shottime;
    private long executiontime;
    private String color;
//    @ManyToOne
//    private User creator;
}