package org.lyflexi.debug_springframework.dependencecircle.dependence_nonaop;


public class Loop {

    private Circle circle;

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
