package com.sberbank.library.repository;

import com.sberbank.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainsIgnoreCase(String title);
    List<Book> findByAuthor_Id(Long id);
    List<Book> findByPublishing_Id(Long id);

}
