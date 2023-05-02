package com.example.javaadvance3;

import javafx.collections.ObservableArray;

public class User {
    int id;
    String company;
    String name;
    int score;
    int delId;

    public int getDelId() {
        return delId;
    }

    public void setDelId(int delId) {
        this.delId = delId;
    }

    public User(int id, String company, String name, int score, int delId) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.score = score;
        this.delId = delId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
