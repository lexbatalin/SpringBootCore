package ru.lexbatalin.library.springbootlibrary.dao.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

// Методы поиска
public interface SearchDao<T> {

    // Поиск записей с любым набором параметров
    List<T> search(String... searchString);

    // Поиск записей с постраничностью
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);
}
