package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Options")
public class Select {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    Long id;

    @Getter
    @Setter
    String option;

    @OneToMany(mappedBy = "id")
    @Getter
    @Setter
    private List<Form> forms;


}
