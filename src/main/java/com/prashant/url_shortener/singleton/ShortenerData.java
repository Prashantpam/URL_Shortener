package com.prashant.url_shortener.singleton;

import static com.prashant.url_shortener.util.EncodeUtil.encode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ShortenerData {
    private Map<String, String> shortToactualUrl;
    private Map<String, String> actualToshortUrl;

    private static String URL = "http://localhost:8080/tiny/";
    private int counter=1;

    public ShortenerData() {
        shortToactualUrl = new HashMap<>();
        actualToshortUrl = new HashMap<>();
    }

    public Optional<String> getActualUrlByShortUrl(String shortUrl) {
        if(shortToactualUrl.containsKey(shortUrl)) {
            return Optional.of(shortUrl);
        } else {
            return Optional.ofNullable(null);
        }
    }

    public Optional<String> getShortUrlByActualUrl(String actualUrl) {
        if(actualToshortUrl.containsKey(actualUrl)) {
            return Optional.of(actualUrl);
        } else {
            return Optional.ofNullable(null);
        }
    }
    public String shortenURL(String originalURL) {

        if (actualToshortUrl.containsKey(originalURL)) {
            return actualToshortUrl.get(originalURL);
        }

        if(shortToactualUrl.containsKey(originalURL)) {
            return originalURL;
        }
        String shortURL = encode(counter++);
        shortURL = URL+shortURL;
        actualToshortUrl.put(originalURL, shortURL);
        shortToactualUrl.put(shortURL, originalURL);
        return shortURL;
    }
}
