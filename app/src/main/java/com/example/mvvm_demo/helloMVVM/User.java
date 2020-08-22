package com.example.mvvm_demo.helloMVVM;

import java.io.Serializable;

   class User implements Serializable {
    private int id;
    private String name;

    public User(int i, String userName) {
        id=i;
        name=userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
