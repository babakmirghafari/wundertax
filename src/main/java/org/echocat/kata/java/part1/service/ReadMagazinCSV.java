package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.MagazinModel;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadMagazinCSV extends ReadFromCSV<ReadMagazinCSV> implements FilterData<MagazinModel>{

    public Set<MagazinModel> returnMagizinItem(String csvName){
        return readFromCSV(csvName).stream().map(mapToItem).collect(Collectors.toSet());
    }
    private Function<String, MagazinModel> mapToItem = (line) -> {
        String[] p = line.split(";");// a CSV has ; separated lines
        MagazinModel item = new MagazinModel();
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
            item.setPublishedAt(p[3]);
        }
        return item;
    };

    @Override
    public Set<MagazinModel> returnFilterIsbn(String value) {
        Set<MagazinModel> magazines=this.returnMagizinItem("magazines");
        return magazines.stream().filter(x->x.getIsbn().equals(value)).collect(Collectors.toSet());
    }

    @Override
    public Set<MagazinModel> returnFilterAuthors(String value) {
        Set<MagazinModel> magazines=this.returnMagizinItem("magazines");
        return magazines.stream().filter(x->x.getAuthors().equals(value)).collect(Collectors.toSet());
    }
}
