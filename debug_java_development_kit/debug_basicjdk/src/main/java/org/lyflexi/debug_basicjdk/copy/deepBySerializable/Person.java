package org.lyflexi.debug_basicjdk.copy.deepBySerializable;

import java.io.*;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/1 10:13
 */
class Person implements Serializable {
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
    // Deep copy method
    public Person deepCopy() throws IOException, ClassNotFoundException {
        // Write object to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);

        // Read object from byte array
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (Person) objectInputStream.readObject();
    }
}
