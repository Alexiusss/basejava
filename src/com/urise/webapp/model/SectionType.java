package com.urise.webapp.model;

public enum SectionType {
    OBJECTIVE("Позиция"),
    PERSONAL("Личные качества"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String titile;

    SectionType(String titile) {
        this.titile = titile;
    }

    public String getTitile() {
        return titile;
    }
}
