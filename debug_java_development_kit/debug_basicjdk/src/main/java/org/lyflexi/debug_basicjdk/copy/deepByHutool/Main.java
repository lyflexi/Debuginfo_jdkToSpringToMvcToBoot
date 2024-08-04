package org.lyflexi.debug_basicjdk.copy.deepByHutool;

import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/1 10:01
 */
public class Main {
    public static void main(String[] args) {
        // Original person object
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Gaming");
        Person originalPerson = new Person("Alice", hobbies);

        // Perform deep copy using Hutool's BeanUtil
        Person deepCopyPerson = ObjectUtil.cloneByStream(originalPerson);

        // Modify the hobbies of deep copy
        deepCopyPerson.getHobbies().add("Hiking");

        // Print original and deep copy
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Deep Copy Person: " + deepCopyPerson);
    }
}
