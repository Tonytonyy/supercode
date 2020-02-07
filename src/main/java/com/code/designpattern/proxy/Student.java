package com.code.designpattern.proxy;

public class Student implements User {

    public Student(){

    }
    public Student(String str){

    }
    @Override
    public void save() {
        System.out.println("Student  save");
    }
    public void upate(User student){

    }
}
