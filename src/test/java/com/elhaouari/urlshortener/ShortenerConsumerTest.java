package com.elhaouari.urlshortener;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShortenerConsumerTest {
    private final ShortenerConsumer shortenerConsumer = new ShortenerConsumer(new UrlShortenerStore());
    private final ShortenerSeoKeyword shortenerSeoKeyword = new ShortenerSeoKeyword(new UrlShortenerStore());

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValidSenario(){
        shortenerSeoKeyword.setKeyword("MY-NEW-WS");
        String shortedUrl = shortenerSeoKeyword.createShortUrl("http://looooong.com/somepath");
        String originalUrl = shortenerConsumer.getLongUrl(shortedUrl);
        Assert.assertEquals("http://looooong.com/somepath", originalUrl);
    }

    @Test
    public void testValidUnvalidSenario(){
        shortenerSeoKeyword.setKeyword("MY-NEW-WS");
        String shortedUrl = shortenerSeoKeyword.createShortUrl("http://looooong.com/somepath");
        String originalUrl = shortenerConsumer.getLongUrl(shortedUrl);
        Assert.assertNotEquals("http://looooong.com/not-matched", originalUrl);
    }

    @Test
    public void testUrlNotExists(){
        String originalUrl = shortenerConsumer.getLongUrl("http://url.com");
        Assert.assertNull(originalUrl);
    }
}
