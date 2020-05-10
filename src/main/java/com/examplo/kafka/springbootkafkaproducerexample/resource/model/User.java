package com.examplo.kafka.springbootkafkaproducerexample.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("name")
    private String name;

    @JsonProperty("dept")
    private String dept;

    @JsonProperty("salary")
    private Long salary;

    public User(String name, String dept, Long salary){
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
