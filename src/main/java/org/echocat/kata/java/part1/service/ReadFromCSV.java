package org.echocat.kata.java.part1.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class ReadFromCSV<T> {

    public Set<String> readFromCSV(String csvName){
        InputStream inputStream=getClass().getResourceAsStream("/org/echocat/kata/java/part1/data/"+csvName+".csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        return br.lines().skip(1).collect(Collectors.toSet());
    }
}
