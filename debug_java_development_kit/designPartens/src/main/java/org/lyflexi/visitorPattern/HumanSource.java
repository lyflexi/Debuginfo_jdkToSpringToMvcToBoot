package org.lyflexi.visitorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/22 14:47
 */
public class HumanSource implements CorporateSlave {
    private String name;

    public HumanSource(String name) {
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
