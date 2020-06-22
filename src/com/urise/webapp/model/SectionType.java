package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVMENT("Достижения"),
    QUALICFICATIONS("Квалификация"),
    EXPERENSE("Опыт работы"),
    EDUCAION("Образование");

    private String titile;

    SectionType(String titile) {
        this.titile = titile;
    }

    public String getTitile() {
        return titile;
    }
}
