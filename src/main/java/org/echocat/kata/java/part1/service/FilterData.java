package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.BookModel;

import java.util.Set;

public interface FilterData<T extends BookModel> {
    public Set<T> returnFilterIsbn(String value);
    public Set<T> returnFilterAuthors(String value);
}
