package org.lyflexi.visitorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/22 14:48
 */
public class Programmer implements CorporateSlave {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(CorporateSlaveVisitor visitor) {
        visitor.visit(this);
    }
}