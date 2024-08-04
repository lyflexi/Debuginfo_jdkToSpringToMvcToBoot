package org.lyflexi.prototypePattern.shallowCopy;

/**
 * @Author: ly
 * @Date: 2024/3/13 21:09
 */

import java.util.ArrayList;
import java.util.List;

public class ProtoTypeTest {
    public static void main(String[] args) throws Exception {
        PrototypeImplA prototypeImplA = new PrototypeImplA();
        prototypeImplA.setAge(18);
        prototypeImplA.setName("张三");
        List<String> phoneList = new ArrayList<>();
        phoneList.add("88888888");
        phoneList.add("77777777");
        prototypeImplA.setPhoneList(phoneList);

        PrototypeImplA cloneProtoType = (PrototypeImplA) prototypeImplA.clone();
        System.out.println(prototypeImplA.getPhoneList() == cloneProtoType.getPhoneList());//true
    }
}

