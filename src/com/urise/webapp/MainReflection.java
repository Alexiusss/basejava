package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Resume r = new Resume();
//        Field declaredField = r.getClass().getDeclaredFields()[0];
//        declaredField.setAccessible(true);
//        System.out.println(declaredField.getName());
//        declaredField.get(r);
//        declaredField.set(r, "new_uuid");
//        System.out.println(declaredField.get(r));
//        System.out.println(r);


        Resume r2 = new Resume("Name");
        System.out.println(r2.toString());
        System.out.println("================================================");

        Class reflecollass = Resume.class;
        Method method = reflecollass.getMethod("toString");
        System.out.println(method.invoke(r2));



    }
}
