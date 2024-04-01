package com.bookvault.repository;

import com.bookvault.model.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookListRepository extends JpaRepository<BookList, Integer> {
}
