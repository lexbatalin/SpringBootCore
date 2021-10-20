package ru.lexbatalin.library.springbootlibrary.dao;

import ru.lexbatalin.library.springbootlibrary.dao.core.BaseDao;
import ru.lexbatalin.library.springbootlibrary.dao.core.SearchDao;
import ru.lexbatalin.library.springbootlibrary.domain.Publisher;

public interface PublisherDao extends BaseDao<Publisher>, SearchDao<Publisher> {

}
