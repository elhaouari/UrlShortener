package com.elhaouari.urlshortener;


public class ShortenerSeoKeyword implements IUrlShortener {
    private String keyword;
    private final IUrlShortenerStore store;

    public ShortenerSeoKeyword(IUrlShortenerStore urlShortenerStore) {
        store = urlShortenerStore;
    }

    public void setKeyword(String seoKeyword) {
        keyword = seoKeyword;
    }

    @Override
    public String createShortUrl(String originalUrl) {
        validateArgs(originalUrl);
        String shortedUrl = generateShortUrl(keyword);
        storeShortedUrl(shortedUrl, originalUrl);
        return shortedUrl;
    }

    private void validateArgs(String originalUrl) {
        validateKeyword(keyword);
        validateUrl(originalUrl);
    }

    private void validateKeyword(String keyword) {
        if (keyword == null || keyword.length() == 0) {
            throw new IllegalArgumentException("Keyword is missing, Please provide a valid SEO keyword");
        }
        if (keyword.length() > 20) {
            throw new IllegalArgumentException("The SEO keyword is more than 20 characters");
        }
    }

    private void validateUrl(String url){
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("The url provided is not valid");
        }
    }

    private String generateShortUrl(String keyword){
        return BASE_URL + keyword;
    }

    private void storeShortedUrl(String shortedUrl, String originalUrl) {
        if (store.isExists(shortedUrl)) {
            throw new IllegalArgumentException("The url provided is already exists");
        }
        store.store(shortedUrl, originalUrl);
    }
}
