package org.lyflexi.prototypePattern.shallowCopy2;

/**
 * @Author: ly
 * @Date: 2024/3/13 21:11
 */

import java.io.*;
import java.util.List;

public class PrototypeB implements Cloneable {
    private String name;

    private int age;

    private List<String> phoneList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

