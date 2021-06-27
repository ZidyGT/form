package com.example.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Options")
public class Select {
    @Id
    @GeneratedValue
    Long id;

    String option;

    @OneToMany(mappedBy = "id")
    private List<Form> forms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }
}
