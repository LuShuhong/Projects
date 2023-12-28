package com.thg.marp;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class SlideTest {

    @Test
    void parseInvalidSlide_throwFileNotFoundException() {
        Slide slide = new Slide("./invalid-path.md");
        Set<String> dictionarySet =  new HashSet<>(Arrays.asList("apple","banana","cat","dog"));

        assertThrows(FileNotFoundException.class,() ->slide.parseSlide(dictionarySet));
    }

    @Test
    void parseValidSlide() {
        Slide slide = new Slide("./src/main/resources/testSlide.md");
        Set<String> dictionarySet =  new HashSet<>(Arrays.asList("apple","banana","cat","dog","engineering"));
        assertDoesNotThrow(()->{slide.parseSlide(dictionarySet);});

        assertTrue(slide.getNumberOfSlides()>10);
        assertFalse(slide.getNumberOfWords()<100);
        assertNotEquals(100,slide.getNumberOfImages());
        assertNotNull(slide.getHeadings());
        assertTrue(slide.getIncorrectWords().containsKey("software"));
        assertFalse(slide.getIncorrectWords().containsKey("engineering"));

    }


}