package org.lyflexi.iteratorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:08
 */
public interface IBaggageAggregate {
    void add(Baggage baggage);

    void remove(Baggage baggage);

    int size();

    IMyIterator<Baggage> iterator();
}
