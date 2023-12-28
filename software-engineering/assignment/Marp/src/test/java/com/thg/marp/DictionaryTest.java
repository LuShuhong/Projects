package com.thg.marp;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DictionaryTest {

    @Test
    void parseUserDict() {
        Dictionary dictionary = new Dictionary("/usr/share/dict/words");
        Set<String> words = null;

        try {
            words = dictionary.parseDict();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        assertTrue(words.size() > 0);
        assertTrue(words.contains("happy"));
        assertFalse(words.contains("nonexistentWord"));


    }

    @Test
    void parseDefaultDict() {
        Dictionary dictionary = new Dictionary("./non-existent-path");
        Set<String> words = null;

        try {
            words = dictionary.parseDict();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        assertTrue(words.size() > 0);
        assertTrue(words.contains("happy"));
        assertFalse(words.contains("nonexistentWord"));

    }
}
