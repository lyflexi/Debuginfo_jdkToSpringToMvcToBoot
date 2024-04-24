package org.lyflexi.mediatorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 12:55
 */
public abstract class AbstractPlane {
    protected AbstractMediator mediator;

    public AbstractPlane(AbstractMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void fly();
}

