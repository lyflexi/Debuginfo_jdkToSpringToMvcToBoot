package org.lyflexi.debug_basicjdk.copy.deepByHutool;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/1 10:00
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
