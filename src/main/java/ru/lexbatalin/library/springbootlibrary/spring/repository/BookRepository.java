package ru.lexbatalin.library.springbootlibrary.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lexbatalin.library.springbootlibrary.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String name, String fio);

    @Query("select new ru.lexbatalin.library.springbootlibrary.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.publishYear, b.image, b.descr, b.viewCount, b.totalRating, b.totalVoteCount, b.avgRating) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);

    @Modifying(clearAutomatically = true) // нужен если запрос изменяет данные
    @Query("update Book b set b.content=:content where b.id=:id")
    void updateContent(@Param("content") byte[] content, @Param("id") long id);

    //ищем топовые книги, для них необходимо только изображение
    @Query("select new ru.lexbatalin.library.springbootlibrary.domain.Book(b.id, b.image) from Book b")
    List<Book> findTopBooks(Pageable pageable);

    //поиск книг по жанру
    @Query("select new ru.lexbatalin.library.springbootlibrary.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.publishYear, b.image, b.descr, b.viewCount, b.totalRating, b.totalVoteCount, b.avgRating) from Book b where b.genre.id=:genreId")
    Page<Book> findByGenre(@Param("genreId") long genreId, Pageable pageable);

    // получение контента по id книги
    @Query("select b.content from book where b.id=:id")
    byte[] getContent(@Param("id") long id);

}
