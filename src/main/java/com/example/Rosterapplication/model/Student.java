package com.example.Rosterapplication.model;

import nonapi.io.github.classgraph.json.Id;

public class Student {
    private int age;
    private String name;
    @Id
    private long id;
    private int gradYear;
    private String major;

    public Student(int age, String name, long id, int gradYear, String major)
    {
        this.age=age;
        this.name=name;
        this.id=id;
        this.gradYear=gradYear;
        this.major=major;
    }
    public int getAge() {return age;}
    public void setAge(int newAge) {  this.age=newAge;}
    public String getName() {return name;}
    public void setName(String name) {this.name=name;}
    public void changeName(String newName){this.name=newName;}
    public long getId(){return id;}
    public void setId(long newid) {this.id = newid;}
    public int getGradYear(){return gradYear;}
    public void setGradYear(int newGradYear){this.gradYear=newGradYear;}
    public String getMajor() {return major;}
    public void setMajor(String newMajor){this.major=newMajor;}

}
