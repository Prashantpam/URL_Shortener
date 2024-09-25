package com.prashant.url_shortener.service;

import com.prashant.url_shortener.singleton.ShortenerData;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private ShortenerData shortenerData;

    public UrlService(ShortenerData shortenerData) {
        this.shortenerData = shortenerData;
    }

    public String makeShort(String url) {
        return shortenerData.shortenURL(url);
    }
}
