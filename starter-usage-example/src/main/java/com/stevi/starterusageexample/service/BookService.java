package com.stevi.starterusageexample.service;

import com.stevi.starterusageexample.entity.Book;
import com.stevi.starterusageexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book createBook(String name) {
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository
                .findById(id)
                .ifPresent(bookRepository::delete);
    }
}
