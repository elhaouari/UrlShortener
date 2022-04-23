package com.elhaouari.urlshortener;

public interface IUrlShortener {
    String BASE_URL = "https://short.com/";

    String createShortUrl(String originalUrl);
}

