package ru.lexbatalin.library.springbootlibrary.dao.core;

import java.util.List;

public interface SearchDao<T> {

    List<T> search(String... searchString);
}
