package com.elhaouari.urlshortener;

public class ShortenerWithRandomKeyword implements IUrlShortener{
    private final IUrlShortenerStore store;

    private final String ALPHA_NUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private final int MAX_KEY_LENGHT = 4;

    public ShortenerWithRandomKeyword(IUrlShortenerStore urlShortenerStore) {
        store = urlShortenerStore;
    }

    @Override
    public String createShortUrl(String originalUrl) {
        String shortedUrl = generateUrl();
        store.store(shortedUrl, originalUrl);
        return shortedUrl;
    }

    private String generateUrl(){
        String randomSuffix = StringGenerator.generateRandomString(ALPHA_NUMERIC, MAX_KEY_LENGHT);
        String shortedUrl = BASE_URL + randomSuffix;
        if (store.isExists(shortedUrl)) {
            return generateUrl();
        }
        return shortedUrl;
    }
}
