package org.lyflexi.clone;

/**
 * @Author: ly
 * @Date: 2024/2/23 17:20
 */
public class Helper implements Cloneable{
    public int num;

    public Helper(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Helper{" +
                "num=" + num +
                '}';
    }
    //重写clone
    @Override
    protected Helper clone() throws CloneNotSupportedException {
        Helper clone = (Helper) super.clone();
        return clone;
    }
}
