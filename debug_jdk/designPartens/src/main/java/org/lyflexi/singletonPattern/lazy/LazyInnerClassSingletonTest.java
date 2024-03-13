package org.lyflexi.singletonPattern.lazy;

/**
 * @Author: ly
 * @Date: 2024/3/13 20:19
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LazyInnerClassSingletonTest {

//    测试内部类单例模式的反射攻击
//    public static void main(String[] args) throws Exception {
//        Class<?> clazz = LazyInnerClassSingleton.class;
//        Constructor constructor = clazz.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        Object o1 = constructor.newInstance();
//        Object o2 = LazyInnerClassSingleton.getInstance();
//        System.out.println(o1 == o2);//内部类单例需要防反射攻击，否则此处结果是false会创建多个实例
//    }


//测试内部类单实例模式的序列化攻击
    public static void main(String[] args) throws Exception {
        LazyInnerClassSingleton s1 = null;
        LazyInnerClassSingleton s2 = LazyInnerClassSingleton.getInstance();

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("LazyInnerClassSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);//将s2保存到文件"LazyInnerClassSingleton.obj"中。
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("LazyInnerClassSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (LazyInnerClassSingleton)ois.readObject();//从文件"LazyInnerClassSingleton.obj"中读取到s1中
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);//内部类单例需要防序列化攻击，否则此处结果是false会创建多个实例
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

