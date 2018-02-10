package com.basaki.service;

import com.basaki.annotation.CustomAnnotation;
import com.basaki.data.entity.Book;
import com.basaki.data.repository.BookRepository;
import com.basaki.model.BookRequest;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * {@code BookService} provides CRUD functioanality on book.
 * <p/>
 *
 * @author Indra Basak
 * @since 11/20/17
 */
@Service
public class BookService {

    private static final Logger
            log = LoggerFactory.getLogger(BookService.class);

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book create(BookRequest request) {
        Book entity = validateRequest(request);
        return repository.save(entity);
    }

    public Book read(UUID id) {
        return repository.getOne(id);
    }

    @CustomAnnotation(description = "Validates book request.")
    private Book validateRequest(BookRequest request) {
        log.info("Validating book request!");

        Assert.notNull(request, "Book request cannot be empty!");
        Assert.notNull(request.getTitle(), "Book title cannot be missing!");
        Assert.notNull(request.getAuthor(), "Book author cannot be missing!");

        Book entity = new Book();
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());

        return entity;
    }
}