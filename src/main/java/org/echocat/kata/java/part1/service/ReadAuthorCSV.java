package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.AuthorsModel;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadAuthorCSV extends ReadFromCSV<AuthorsModel> {

    public Set<AuthorsModel> returnAuthorsItem(String csvName){
        return readFromCSV(csvName).stream().map(mapToItem).collect(Collectors.toSet());
    }

    private Function<String, AuthorsModel> mapToItem = (line) -> {
        String[] p = line.split(";");// a CSV has ; separated lines
        AuthorsModel item = new AuthorsModel();
        if (p[0] != null && p[0].trim().length() > 0) {
            item.setEmail(p[0]);
        }

        if (p[1] != null && p[1].trim().length() > 0) {
            item.setFirstName(p[1]);
        }

        if (p[2] != null && p[2].trim().length() > 0) {
            item.setLastName(p[2]);
        }
        return item;
    };
}
