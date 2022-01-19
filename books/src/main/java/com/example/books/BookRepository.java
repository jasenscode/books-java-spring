package com.example.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // new method syntax: <ReturnType> [operation]By[attribute](parameter)

    // find particular Book
    Book findBookByid(int id);

    // delete Book by ID
    String deleteBookByid(int id);
}
