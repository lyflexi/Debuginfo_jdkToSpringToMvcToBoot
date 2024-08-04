package org.lyflexi.mediatorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 16:50
 */

public class TestMediator {
    public static void main(String[] args) {
        AbstractMediator controlTower = new ControlTower();
        PlaneA planeA = new PlaneA(controlTower);
        PlaneB planeB = new PlaneB(controlTower);

        controlTower.setPlaneA(planeA);
        controlTower.setPlaneB(planeB);

        planeA.fly();
        System.out.println("--------------------");
        planeB.fly();
    }
}

