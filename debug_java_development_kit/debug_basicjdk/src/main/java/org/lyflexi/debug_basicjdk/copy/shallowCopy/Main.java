package org.lyflexi.debug_basicjdk.copy.shallowCopy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/1 9:56
 */
public class Main {
    public static void main(String[] args) {
        // Original person object
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Gaming");
        Person originalPerson = new Person("Alice", hobbies);

        // Perform shallow copy
        Person shallowCopyPerson = new Person(originalPerson.getName(), originalPerson.getHobbies());

        // Modify the hobbies of shallow copy
        shallowCopyPerson.getHobbies().add("Hiking");

        // Print original and shallow copy
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Shallow Copy Person: " + shallowCopyPerson);
    }
}
