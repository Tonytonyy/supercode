package com.code.designpattern.proxy;

public class StudentProxy implements User {
    private User user;
    public StudentProxy(User user){
        this.user = user;
    }

    @Override
    public void save() {
        System.out.println("before student save");
        user.save();
        System.out.println("end student save");
    }
}
