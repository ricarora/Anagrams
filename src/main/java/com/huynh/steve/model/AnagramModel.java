package com.huynh.steve.model;

import java.util.Set;

/**
 * Created by stevehuy on 2/27/15.
 */
public class AnagramModel {
    private final String inputString;
    private final Set<String> anagrams;

    public AnagramModel(String inputString, Set<String> anagrams) {
        this.inputString = inputString;
        this.anagrams = anagrams;
    }

    public Set<String> getAnagrams() {
        return anagrams;
    }

    public String getInputString() {
        return inputString;
    }
}
