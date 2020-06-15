package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field declaredField = r.getClass().getDeclaredFields()[0];
        declaredField.setAccessible(true);
        System.out.println(declaredField.getName());
        declaredField.get(r);
        declaredField.set(r, "new_uuid");
        System.out.println(declaredField.get(r));
        // TODO : invoke r.toString via reflection
        System.out.println(r);
    }
}
