package org.lyflexi.prototypePattern.shallowCopy2;

/**
 * @Author: ly
 * @Date: 2024/3/13 21:15
 */

import java.util.ArrayList;
import java.util.List;

public class ProtoTypeTest2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeB prototypeImplB = new PrototypeB();
        prototypeImplB.setAge(18);
        prototypeImplB.setName("张三");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("88888888");
        phoneList.add("77777777");
        prototypeImplB.setPhoneList(phoneList);

        PrototypeB cloneProtoTypeB = (PrototypeB)prototypeImplB.clone();
        System.out.println(prototypeImplB.getPhoneList() == cloneProtoTypeB.getPhoneList());//true
    }
}

