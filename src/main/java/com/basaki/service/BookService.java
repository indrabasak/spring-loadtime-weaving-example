package com.basaki.service;

import com.basaki.annotation.CustomAnnotation;
import com.basaki.data.entity.Book;
import com.basaki.data.repository.BookRepository;
import com.basaki.error.exception.DataNotFoundException;
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

    private final BookRepository repository;

    private final UselessService service;

    @Autowired
    public BookService(BookRepository repository, UselessService service) {
        this.repository = repository;
        this.service = service;
    }

    @Transactional
    public Book create(BookRequest request) {
        service.sayHello("BookService.request");
        Book entity = validateRequest(request);
        return repository.save(entity);
    }

    public Book read(UUID id) {
        service.sayHello("BookService.read");
        try {
            return repository.getOne(id);
        } catch (Exception e) {
            throw new DataNotFoundException(
                    "Book with ID " + id + " not found.");
        }
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