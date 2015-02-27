package com.huynh.steve.anagramsolver;

import com.huynh.steve.dictionary.Dictionary;
import com.huynh.steve.dictionary.EnglishDictionary;

import java.util.*;


/**
 * Created by stevehuy on 2/26/15.
 */
public class AnagramSolver {

    private Dictionary dictionary;
    private Map<String, Set<String>> signatureMap;

    public static AnagramSolver instance;

    public static synchronized AnagramSolver getInstance(Dictionary dictionary) {
        if (instance == null) {
            instance = new AnagramSolver(dictionary);
        }
        return instance;
    }


    private AnagramSolver(Dictionary dictionary) {
        this.dictionary = dictionary;
        signatureMap = new HashMap<String, Set<String>>();
        for (String text : dictionary.getAllWords()) {
            String wordSignature = signature(text);
            if (!signatureMap.containsKey(wordSignature)) {
                signatureMap.put(wordSignature, new HashSet<String>());
            }
            signatureMap.get(wordSignature).add(text);
        }
    }

    public Set<String> getAnagrams(String s) {
        String signature = signature(s);
        if (signatureMap.containsKey(signature)) {
            return signatureMap.get(signature);
        }
        return new HashSet<String>();
    }

    private static String signature(String s) {
        char[] characters = s.toLowerCase().toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    public static void main(String[] args) {
        Dictionary dictionary = EnglishDictionary.getInstance();
        AnagramSolver solver = new AnagramSolver(dictionary);
        Set<String> myAnagrams = solver.getAnagrams("trap");
        for (String s: myAnagrams) {
            System.out.println(s);
        }
    }
}
