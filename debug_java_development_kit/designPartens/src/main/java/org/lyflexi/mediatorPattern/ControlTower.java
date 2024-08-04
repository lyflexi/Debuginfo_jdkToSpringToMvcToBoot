package org.lyflexi.mediatorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 16:49
 */

public class ControlTower extends AbstractMediator{
    @Override
    public void notifyPlaneA() {
        super.planeA.notifyMe();
    }

    @Override
    public void notifyPlaneB() {
        super.planeB.notifyMe();
    }
}

