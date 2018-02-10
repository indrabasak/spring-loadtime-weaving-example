package com.basaki.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@code BookRequest} represents a response during book creation.
 * <p/>
 *
 * @author Indra Basak
 * @since 12/7/17
 */
public class BookRequest {

    private String title;

    private String author;

    @JsonCreator
    public BookRequest(@JsonProperty("title") String title,
            @JsonProperty("author") String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
