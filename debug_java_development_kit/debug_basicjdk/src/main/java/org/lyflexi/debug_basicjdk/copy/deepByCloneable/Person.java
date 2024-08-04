package org.lyflexi.debug_basicjdk.copy.deepByCloneable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/1 10:18
 */
class Person implements Cloneable {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Shallow copy for Person object
        Person clonedPerson = (Person) super.clone();
        // Deep copy for hobbies list
        clonedPerson.hobbies = new ArrayList<>(this.hobbies);
        return clonedPerson;
    }
}
