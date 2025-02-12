package com.example.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "benchpress")
    private int benchPress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBenchPress() {
        return benchPress;
    }

    public void setBenchPress(int benchPress) {
        this.benchPress = benchPress;
    }

    public user() {

    }

    public user(int id, String name,int benchPress) {
        this.benchPress = benchPress;
        this.id = id;
        this.name = name;
    }

    public user(String name,Integer benchPress) {
        this.benchPress = benchPress;
        this.name = name;
    }
}
