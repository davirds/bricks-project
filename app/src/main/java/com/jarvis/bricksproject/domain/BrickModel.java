package com.jarvis.bricksproject.domain;

public class BrickModel {

    private String name;
    private String description;
    private int backGround;

    public BrickModel(String name, String description, int backGround) {
        setName(name);
        setDescription(description);
        setBackGround(backGround);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBackGround() {
        return backGround;
    }

    public void setBackGround(int backGround) {
        this.backGround = backGround;
    }
}

