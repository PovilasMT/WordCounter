package com.example.wordcounter;

public class TextCounter {

    public static int countWords(String text) {
        if (text == null) return 0;

        String trimmed = text.trim();
        if (trimmed.isEmpty()) return 0;

        return trimmed.split("\\s+").length;
    }
}
