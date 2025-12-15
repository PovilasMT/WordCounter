package com.example.wordcounter;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextCounterTest {

    @Test
    public void countWords_emptyString_returnsZero() {
        int result = TextCounter.countWords("");
        assertEquals(0, result);
    }

    @Test
    public void countWords_singleWord_returnsOne() {
        int result = TextCounter.countWords("Hello");
        assertEquals(1, result);
    }

    @Test
    public void countWords_multipleWords_returnsCorrectCount() {
        int result = TextCounter.countWords("Hello world from Android");
        assertEquals(4, result);
    }

    @Test
    public void countWords_extraSpaces_returnsCorrectCount() {
        int result = TextCounter.countWords("   Hello   world   ");
        assertEquals(2, result);
    }

    @Test
    public void countWords_null_returnsZero() {
        int result = TextCounter.countWords(null);
        assertEquals(0, result);
    }
}
