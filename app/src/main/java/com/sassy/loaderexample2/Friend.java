package com.sassy.loaderexample2;

public class Friend {

    private String name;
    private boolean gender;

    public Friend(String name, boolean gender) {
        this.gender = gender;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

}
