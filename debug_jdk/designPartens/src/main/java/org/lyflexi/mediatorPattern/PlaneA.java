package org.lyflexi.mediatorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:55
 */
public class PlaneA extends AbstractPlane {

    public PlaneA(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void fly() {
        System.out.println("我是PlaneA，要过航线，请让道");
        super.mediator.notifyPlaneB();
    }

    public void notifyMe(){
        System.out.println("我是PlaneA，已收到通知，准备让道");
    }
}
