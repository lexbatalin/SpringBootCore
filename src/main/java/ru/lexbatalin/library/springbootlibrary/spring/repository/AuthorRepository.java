package ru.lexbatalin.library.springbootlibrary.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lexbatalin.library.springbootlibrary.domain.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFioContainingIgnoreCaseOrderByFio(String fio);

    // Page содержит результаты выполнения запроса и служебные данные для постраничности
    // Pageable параметры для постраничности
    Page<Author> findByFioContainingIgnoreCAseOrderByFio(String fio, Pageable pageable);
}
