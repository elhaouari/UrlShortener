package com.elhaouari.urlshortener;

import java.util.HashMap;
import java.util.Map;

public class UrlShortenerStore implements IUrlShortenerStore {
    private static Map<String, String> inMemoryurlStore = new HashMap<>();

    @Override
    public void store(String shortedUrl, String originalUrl) {
        inMemoryurlStore.put(shortedUrl, originalUrl);
    }

    @Override
    public boolean isExists(String shortedUrl){
        return inMemoryurlStore.containsKey(shortedUrl);
    }

    @Override
    public String get(String shortedUrl) {
        return inMemoryurlStore.get(shortedUrl);
    }
}
