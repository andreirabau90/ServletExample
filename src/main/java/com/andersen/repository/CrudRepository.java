package com.andersen.repository;

import java.util.List;

public interface CrudRepository<T> {
    T get(long id);

    void saveOrUpdate(T t);

    void delete(T t);

    List<T> getAll();
}
