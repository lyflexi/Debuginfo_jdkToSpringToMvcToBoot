package org.lyflexi.iteratorPattern;


import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:06
 */
public class MyIteratorImpl<E> implements IMyIterator<E> {
    private List<E> list;
    private int cursor;
    private E element;
    private int size;

    public MyIteratorImpl(List<E> list) {
        this.list = list;
        this.size = list.size();
    }

    @Override
    public E next() {
        E element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        return cursor != size;
    }
}

