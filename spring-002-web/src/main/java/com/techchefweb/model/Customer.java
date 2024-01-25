package com.techchefweb.model;

public class Customer {
    private String nif;
    private String fistName;
    private Integer age;
    private Boolean active;


    @Override
    public String toString() {
        return "Customer{" +
                "nif='" + nif + '\'' +
                ", fistName='" + fistName + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }



    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Customer(String nif, String fistName, Integer age, Boolean active) {
        this.nif = nif;
        this.fistName = fistName;
        this.age = age;
        this.active = active;
    }
}
