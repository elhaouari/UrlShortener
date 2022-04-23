package com.elhaouari.urlshortener;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShortenerSeoKeywordTest {

    private final ShortenerSeoKeyword shortenUrlSeo = new ShortenerSeoKeyword(new UrlShortenerStore());

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValidSenario(){
        shortenUrlSeo.setKeyword("MY-NEW-WS");
        String actual = shortenUrlSeo.createShortUrl("http://looooong.com/somepath");
        Assert.assertEquals("https://short.com/MY-NEW-WS", actual);
    }

    @Test
    public void testValidSenario2(){
        shortenUrlSeo.setKeyword("POTATO");
        String actual = shortenUrlSeo.createShortUrl("http://looooong.net/another/somepath");
        Assert.assertEquals("https://short.com/POTATO", actual);
    }

    @Test
    public void testKeywordMoreThan20Chars(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The SEO keyword is more than 20 characters");
        shortenUrlSeo.setKeyword("THIS IS A LONG KEYWORD, THE CLASS SHOULD THROW AN EXCEPTION");
        shortenUrlSeo.createShortUrl("https://looooong.net/another/somepath");
    }

    @Test
    public void testUrlIsNotValid(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The url provided is not valid");
        shortenUrlSeo.setKeyword("POTATO");
        shortenUrlSeo.createShortUrl("url not valid");
    }

    @Test
    public void testUrlAlreadyExists(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The url provided is already exists");

        shortenUrlSeo.setKeyword("POTATO");
        shortenUrlSeo.createShortUrl("https://looooong.net/another/somepath");
        shortenUrlSeo.createShortUrl("https://looooong.net/another/somepath");
    }

    @Test
    public void testKeywordMissing(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Keyword is missing, Please provide a valid SEO keyword");
        shortenUrlSeo.createShortUrl("https://looooong.net/another/somepath");
    }
}
