package com.huynh.steve;

import com.huynh.steve.anagramsolver.AnagramSolver;
import com.huynh.steve.dictionary.EnglishDictionary;
import com.huynh.steve.model.AnagramModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * Created by stevehuy on 2/27/15.
 */
@Path("anagrams/{word}")
public class Anagram {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AnagramModel getIt(@PathParam("word") String word) {
        AnagramSolver solver = AnagramSolver.getInstance(EnglishDictionary.getInstance());
        Set<String> words = solver.getAnagrams(word);
        StringBuilder builder = new StringBuilder();
        AnagramModel model = new AnagramModel(word, words);
        return model;
    }
}
