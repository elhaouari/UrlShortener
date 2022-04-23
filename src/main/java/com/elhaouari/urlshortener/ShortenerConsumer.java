package com.elhaouari.urlshortener;

public class ShortenerConsumer {
    private final IUrlShortenerStore store;
    public ShortenerConsumer(IUrlShortenerStore urlShortenerStore) {
        store = urlShortenerStore;
    }

    public String getLongUrl(String shortedUrl) {
        return store.get(shortedUrl);
    }
}
