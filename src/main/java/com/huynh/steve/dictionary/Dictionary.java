package com.huynh.steve.dictionary;

import java.util.Set;

/**
 * Created by stevehuy on 2/26/15.
 */
public interface Dictionary {
    public boolean isWord(String s);
    public Set<String> getAllWords();
}
