package com.prashant.url_shortener.controller;

import com.prashant.url_shortener.service.UrlService;
import com.prashant.url_shortener.singleton.ShortenerData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tiny")
public class UrlController {

    private UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    @GetMapping
    public String getShortUrl(@RequestParam("url") String url) {
        return urlService.makeShort(url);
    }
}
