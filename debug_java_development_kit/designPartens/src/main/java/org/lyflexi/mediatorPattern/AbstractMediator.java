package org.lyflexi.mediatorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 16:49
 */

public abstract class AbstractMediator {
    protected PlaneA planeA;
    protected PlaneB planeB;

    public void setPlaneA(PlaneA planeA) {
        this.planeA = planeA;
    }

    public void setPlaneB(PlaneB planeB) {
        this.planeB = planeB;
    }

    public abstract void notifyPlaneA();

    public abstract void notifyPlaneB();
}

