package ru.lexbatalin.library.springbootlibrary.dao.core;

import java.util.List;

public interface BaseDao<T> {
    List<T> getAll();
    T getById(long id);
    T save(T obj);
    void delete(T obj);
}
