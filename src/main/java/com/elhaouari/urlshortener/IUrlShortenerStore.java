package com.elhaouari.urlshortener;

public interface IUrlShortenerStore {
    void store(String shortedUrl, String originalUrl);

    boolean isExists(String shortedUrl);

    String get(String shortedUrl);
}
