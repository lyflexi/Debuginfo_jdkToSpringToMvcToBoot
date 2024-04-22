package org.lyflexi.visitorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/22 14:50
 */
public interface CorporateSlaveVisitor {
    void visit(Programmer programmer);

    void visit(HumanSource humanSource);

    void visit(Tester tester);
}
