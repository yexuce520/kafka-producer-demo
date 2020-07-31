package com.richinfo.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 3749347951912513888L;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
