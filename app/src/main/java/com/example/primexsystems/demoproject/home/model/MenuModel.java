package com.example.primexsystems.demoproject.home.model;

public class MenuModel {

    public String menuName, position;
    public boolean hasChildren, isGroup;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren, String position) {

        this.menuName = menuName;
        this.position = position;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}
