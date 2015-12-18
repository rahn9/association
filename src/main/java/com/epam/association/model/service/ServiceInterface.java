package com.epam.association.model.service;

import java.util.List;

public interface ServiceInterface<T> {

    void create(T entity);

    void delete(int id);

    void update(T entity);

    T find(int id);

    List<T> getList(int number);


}
