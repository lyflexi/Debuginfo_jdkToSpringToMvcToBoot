package org.lyflexi.circle;


public class Loop {

    private Circle circle;

    private C c;

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
