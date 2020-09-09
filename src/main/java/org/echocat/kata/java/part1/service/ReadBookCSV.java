package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.BookModel;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadBookCSV extends ReadFromCSV<BookModel> implements FilterData<BookModel>{

    public Set<BookModel> returnMagizinItem(String csvName){
        return readFromCSV(csvName).stream().map(mapToItem).collect(Collectors.toSet());
    }
    private Function<String, BookModel> mapToItem = (line) -> {
        String[] p = line.split(";");// a CSV has ; separated lines
        BookModel item = new BookModel();
        if (p[0] != null && p[0].trim().length() > 0) {
            item.setTitle(p[0]);
        }

        if (p[1] != null && p[1].trim().length() > 0) {
            item.setIsbn(p[1]);
        }

        if (p[2] != null && p[2].trim().length() > 0) {
            item.setAuthors(p[2]);
        }

        if (p[3] != null && p[3].trim().length() > 0) {
            item.setDescription(p[3]);
        }
        return item;
    };

    @Override
    public Set<BookModel> returnFilterIsbn(String value) {
        Set<BookModel> books=this.returnMagizinItem("books");
        return books.stream().filter(x->x.getIsbn().equals(value)).collect(Collectors.toSet());
    }

    @Override
    public Set<BookModel> returnFilterAuthors(String value) {
        Set<BookModel> books=this.returnMagizinItem("books");
        return books.stream().filter(x->x.getAuthors().equals(value)).collect(Collectors.toSet());
    }
}
