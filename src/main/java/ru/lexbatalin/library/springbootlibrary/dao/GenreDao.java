package ru.lexbatalin.library.springbootlibrary.dao;

import ru.lexbatalin.library.springbootlibrary.dao.core.BaseDao;
import ru.lexbatalin.library.springbootlibrary.dao.core.SearchDao;
import ru.lexbatalin.library.springbootlibrary.domain.Genre;

public interface GenreDao extends BaseDao<Genre>, SearchDao<Genre> {

}
