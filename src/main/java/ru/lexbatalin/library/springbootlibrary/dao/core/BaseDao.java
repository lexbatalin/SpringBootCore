package ru.lexbatalin.library.springbootlibrary.dao.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

//Основные операции
public interface BaseDao<T> {

    // Получение всех записей без постраничности
    List<T> getAll();

    //Получение записей по id
    T getById(long id);

    // Обновление/добавление объекта
    T save(T obj);

    // Удаление объекта
    void delete(T obj);

    // Получение всех записей с сортировкой результата
    List<T> getAll(Sort sort);

    // Получение всех записей с постраничностью
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
}
