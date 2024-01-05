package org.lyflexi.debug_springframework.dependencecircle.dependence_nonaop;


public class Circle {

    private Loop loop;

    public Loop getLoop() {
        return loop;
    }

    public void setLoop(Loop loop) {
        this.loop = loop;
    }

    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
