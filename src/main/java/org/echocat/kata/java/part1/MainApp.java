package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.model.BookModel;
import org.echocat.kata.java.part1.model.MagazinModel;
import org.echocat.kata.java.part1.service.ReadAuthorCSV;
import org.echocat.kata.java.part1.service.ReadMagazinCSV;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) {
        System.out.println(getHelloWorldText());
        ReadAuthorCSV r=new ReadAuthorCSV();
        r.returnAuthorsItem("authors").forEach(x->{
            System.out.println(x.getEmail()+"*"+x.getFirstName()+"*"+x.getLastName());

        });
        ReadMagazinCSV r2=new ReadMagazinCSV();
        r2.returnMagizinItem("magazines").forEach(x->{
            System.out.println(x.getTitle()+"*"+x.getIsbn()+"*"+x.getAuthors()+x.getPublishedAt());

        });

        /**
         * This Two lines of code only for describe my solution for solve sort by title , because of I have
         * not enough time I can not implement that.
         */
        System.out.println(r2.returnMagizinItem("magazines")
                .stream().sorted(Comparator.comparing(MagazinModel::getTitle)));

        System.out.println(r2.returnMagizinItem("Books")
                .stream().sorted(Comparator.comparing(BookModel::getTitle)));
    }

    protected static String getHelloWorldText() {
        return "Hello world!";
    }

}
