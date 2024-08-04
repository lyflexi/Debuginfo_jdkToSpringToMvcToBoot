package org.lyflexi.iteratorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:09
 */

import java.util.ArrayList;
import java.util.List;

public class BaggageAggregateImpl implements IBaggageAggregate {
    private List list;

    public BaggageAggregateImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Baggage baggage) {
        list.add(baggage);
    }

    @Override
    public void remove(Baggage baggage) {
        list.remove(baggage);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public IMyIterator<Baggage> iterator() {
        return new MyIteratorImpl<Baggage>(list);
    }
}
