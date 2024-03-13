package org.lyflexi.prototypePattern.deepCopy;

/**
 * @Author: ly
 * @Date: 2024/3/13 21:15
 */


import java.util.ArrayList;
import java.util.List;

public class ProtoTypeTest3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeC prototypeImplC = new PrototypeC();
        prototypeImplC.setAge(18);
        prototypeImplC.setName("张三");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("88888888");
        phoneList.add("77777777");
        prototypeImplC.setPhoneList(phoneList);

        PrototypeC clonePrototypeC = (PrototypeC)prototypeImplC.clone();
        System.out.println(prototypeImplC.getPhoneList() == clonePrototypeC.getPhoneList());//false
    }
}

