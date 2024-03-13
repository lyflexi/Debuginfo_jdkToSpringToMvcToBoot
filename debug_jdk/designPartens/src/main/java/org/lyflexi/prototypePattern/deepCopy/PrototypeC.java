package org.lyflexi.prototypePattern.deepCopy;

/**
 * @Author: ly
 * @Date: 2024/3/13 21:15
 */


import org.lyflexi.prototypePattern.shallowCopy2.PrototypeB;

import java.io.*;
import java.util.List;

public class PrototypeC implements Cloneable, Serializable {
    private String name;

    private int age;

    private List<String> phoneList;

    public String getName() {
        return name;
    }

    public void setName(String name) throws CloneNotSupportedException{
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
//        return super.clone();
        return this.deepClone();
    }

    public PrototypeC deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            PrototypeC clone = (PrototypeC)ois.readObject();
            return clone;
        }catch (Exception e){
            return null;
        }
    }
}

