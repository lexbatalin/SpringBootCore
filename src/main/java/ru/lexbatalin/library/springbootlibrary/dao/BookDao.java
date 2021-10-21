package ru.lexbatalin.library.springbootlibrary.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.lexbatalin.library.springbootlibrary.dao.core.BaseDao;
import ru.lexbatalin.library.springbootlibrary.dao.core.SearchDao;
import ru.lexbatalin.library.springbootlibrary.domain.Book;

import java.util.List;

public interface BookDao extends BaseDao<Book>, SearchDao<Book> {

    //поиск топовых книг
    List<Book> findTopBooks(int limit);

    //Получение контента
    byte[] getContent(long id);

    // вывод книг по жанру с постраничностью
    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);
}
