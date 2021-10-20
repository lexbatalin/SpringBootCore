package ru.lexbatalin.library.springbootlibrary.dao;

import ru.lexbatalin.library.springbootlibrary.dao.core.BaseDao;
import ru.lexbatalin.library.springbootlibrary.dao.core.SearchDao;
import ru.lexbatalin.library.springbootlibrary.domain.Book;

import java.util.List;

public interface BookDao extends BaseDao<Book>, SearchDao<Book> {

    List<Book> findTopBooks(int limit);
}
