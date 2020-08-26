package com.arca.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    private Long time;

    @Column(name = "number")
    private Integer number;

    @Column(name = "origine")
    private String origine;

    public Person() {

    }
}
