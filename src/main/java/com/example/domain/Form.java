package com.example.domain;

import com.example.domain.Select;

import javax.persistence.*;

@Entity
@Table(name = "Forms")
public class Form {
    @Id
    @GeneratedValue(generator = "forms_id_seq")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "select_id")
    private Select select;

    private String number;

    private String name;

    private String surname;

    private String request;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
