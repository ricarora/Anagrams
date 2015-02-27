package com.huynh.steve.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stevehuy on 2/26/15.
 */
public class EnglishDictionary implements Dictionary {

    private Set<String> words;
    private static EnglishDictionary instance;

    public static synchronized EnglishDictionary getInstance() {
        if (instance == null) {
            instance = new EnglishDictionary();
        }
        return instance;
    }

    private EnglishDictionary() {


        words = new HashSet<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("words"));
            String text;

            while ((text = in.readLine()) != null) {
                words.add(text);

            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean isWord(String s) {
        return words.contains(s);
    }

    @Override
    public Set<String> getAllWords() {
        return words;
    }

    public static void main(String[] args) {

    }
}
