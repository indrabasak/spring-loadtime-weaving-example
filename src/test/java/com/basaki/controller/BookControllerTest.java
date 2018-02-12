package com.basaki.controller;

import com.basaki.data.entity.Book;
import com.basaki.error.exception.DataNotFoundException;
import com.basaki.model.BookRequest;
import com.basaki.service.BookService;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * {@code BookControllerTest} represents unit test for {@code
 * BookController}.
 * <p/>
 *
 * @author Indra Basak
 * @since 02/10/18
 */
public class BookControllerTest {

    @Mock
    private BookService service;

    @InjectMocks
    private BookController controller;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Indra's Chronicle");
        book.setAuthor("Indra");
        when(service.create(any(BookRequest.class))).thenReturn(book);

        BookRequest request = new BookRequest("Indra's Chronicle", "Indra");
        Book result = controller.create(request);
        assertNotNull(result);
        assertEquals(book, result);
    }

    @Test
    public void testRead() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Indra's Chronicle");
        book.setAuthor("Indra");
        when(service.read(any(UUID.class))).thenReturn(book);

        Book result = controller.read(UUID.randomUUID());
        assertNotNull(result);
        assertEquals(book, result);
    }

    @Test(expected = DataNotFoundException.class)
    public void testDataNotFoundRead() {
        when(service.read(any(UUID.class))).thenThrow(
                new DataNotFoundException("Not Found!"));

        controller.read(UUID.randomUUID());
    }
}
