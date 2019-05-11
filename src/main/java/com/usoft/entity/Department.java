package com.usoft.entity;

import javax.persistence.*;

/**
 * @author zc
 * @create 2019-05_11-16:21
 */
@Cacheable
@Table(name = "department")
@Entity
public class Department {

    @GeneratedValue
    @Id
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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

    public Department(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public Department() {

    }
}
