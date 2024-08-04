package org.lyflexi.iteratorPattern;

/**
 * @Author: ly
 * @Date: 2024/4/14 17:05
 */
public interface IMyIterator<E> {
    E next();

    boolean hasNext();
}
