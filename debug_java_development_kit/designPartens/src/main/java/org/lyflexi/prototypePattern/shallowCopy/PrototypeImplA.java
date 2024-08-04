package org.lyflexi.prototypePattern.shallowCopy;

/**
 * @Author: ly
 * @Date: 2024/3/13 21:09
 */

import java.util.List;

public class PrototypeImplA implements IPrototype{
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

    @Override
    public IPrototype clone() {
        PrototypeImplA prototypeImplA = new PrototypeImplA();
        prototypeImplA.setAge(this.age);
        prototypeImplA.setName(this.name);
        prototypeImplA.setPhoneList(this.phoneList);
        return prototypeImplA;
    }
}

