package org.lyflexi.clone;

/**
 * @Author: ly
 * @Date: 2024/2/23 17:18
 */
public class DeepClone implements Cloneable {
    private int num;
    private String name;
    private Helper helper;//引用型成员变量也需要克隆，防止

    public DeepClone() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Helper getHelper() {
        return helper;
    }
    //重写clone
    @Override
    protected DeepClone clone() throws CloneNotSupportedException {
        DeepClone clone = (DeepClone) super.clone();
        clone.helper = helper.clone();//关键，成员变量Helper也需要helper.clone()
        return clone;
    }

    @Override
    public String toString() {
        return "CloneDemo{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", helper=" + helper +
                '}';
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        DeepClone d1 = new DeepClone();
        d1.setName("Jack");
        d1.setNum(10);
        d1.setHelper(new Helper(100));

        DeepClone d2 = (DeepClone) d1.clone();
        System.out.println(d1.name == d2.name);
        System.out.println(d1.num == d2.num);
        System.out.println(d1.helper == d2.helper);
        System.out.println("d1.helper:"+d1.helper);
        System.out.println("d2.helper:"+d2.helper);
        /*Output:false代表引用类型Helper实现了深拷贝
        true
        true
        false
        */

        d2.setNum(11);
        d2.setName("json");
        d2.getHelper().setNum(101);
        System.out.println(d1.name);
        System.out.println(d1.num);
        System.out.println(d1.helper.toString());
        System.out.println(d2.name);
        System.out.println(d2.num);
        System.out.println(d2.helper.toString());
        /*Output:d1和d2互不影响
        Jack
        10
        Helper{num=100}

        json
        11
        Helper{num=101}
        */
    }
}
