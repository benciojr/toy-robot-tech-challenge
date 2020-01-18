package com.reagroup.app.factory;

import com.reagroup.app.exception.FactoryException;

public interface AbstractFactory<T> {
    T create(String... parameters) throws FactoryException;
}
