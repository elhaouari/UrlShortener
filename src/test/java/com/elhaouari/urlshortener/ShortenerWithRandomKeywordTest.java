package com.elhaouari.urlshortener;

import org.junit.Assert;
import org.junit.Test;

public class ShortenerWithRandomKeywordTest {

    private final ShortenerWithRandomKeyword shortener = new ShortenerWithRandomKeyword(new UrlShortenerStore());

    @Test
    public void testSuffixLenght4() {
        String expected = shortener.createShortUrl("http://looooong.com/somepath");
        String suffix = expected.substring(expected.length() - 4);
        Assert.assertEquals(4, suffix.length());
    }

    @Test
    public void testSuffixLenghtDifferThan4() {
        String expected = shortener.createShortUrl("http://looooong.com/somepath");
        String suffix = expected.substring(expected.length() - 4);
        Assert.assertNotEquals(5, suffix.length());
    }

    @Test
    public void testSuffixIsAlpha() {
        String expected = shortener.createShortUrl("http://looooong.com/somepath");
        String suffix = expected.substring(expected.length() - 4);
        for (char c : suffix.toCharArray()) {
            Assert.assertTrue(Character.isAlphabetic(c));
        }
    }
}
