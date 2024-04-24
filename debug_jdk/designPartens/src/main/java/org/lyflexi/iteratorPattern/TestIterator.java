package org.lyflexi.iteratorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:10
 */

public class TestIterator {
    public static void main(String[] args) {
        IBaggageAggregate iBaggageAggregate = initBaggage();
        System.out.println("当前对象元素个数为：" + iBaggageAggregate.size() + "个");
        IMyIterator<Baggage> it = iBaggageAggregate.iterator();
        while (it.hasNext()){
            Baggage baggage = it.next();
            System.out.println(baggage.getName());
        }
    }

    private static IBaggageAggregate initBaggage() {
        IBaggageAggregate iBaggageAggregate = new BaggageAggregateImpl();
        for (int i=0;i<10;i++){
            Baggage box = new Baggage("箱子" + (i+1));
            iBaggageAggregate.add(box);
        }
        return iBaggageAggregate;
    }
}

