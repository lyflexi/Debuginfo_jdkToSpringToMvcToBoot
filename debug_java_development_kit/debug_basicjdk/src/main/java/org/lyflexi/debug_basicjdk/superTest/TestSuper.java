package org.lyflexi.debug_basicjdk.superTest;

public class TestSuper {
    public static class Person {

        Person() {
            System.out.println("父类·无参数构造方法： "+"A Person.");
        }//构造方法(1)

        Person(String name) {
            System.out.println("父类·含一个参数的构造方法： "+"A person's name is " + name);
        }//构造方法(2)
    }

    public static class Chinese extends Person {
        Chinese() {
//            super(); // 调用父类构造方法（1）
            System.out.println("子类·调用父类无参数构造方法： "+"A chinese coder.");
        }

        Chinese(String name) {
//            super(name);// 调用父类具有相同形参的构造方法（2）
            System.out.println("子类·调用父类含一个参数的构造方法： "+"his name is " + name);
        }

        Chinese(String name, int age) {
            this(name);// 调用具有相同形参的构造方法（3）
            System.out.println("子类：调用子类具有相同形参的构造方法：his age is " + age);
        }
    }
    public static void main(String[] args) {
        Chinese cn = new Chinese();
        cn = new Chinese("codersai");
        cn = new Chinese("codersai", 18);
    }
}
