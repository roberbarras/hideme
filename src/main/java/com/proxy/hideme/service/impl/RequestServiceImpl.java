package com.proxy.hideme.service.impl;

import com.proxy.hideme.service.RequestService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Override
    public String sendRequest() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .callTimeout(Duration.ofHours(1))
                .build();

        Request request = new Request.Builder()
                .url("https://hidemy.name/es/proxy-list/?maxtime=500&anon=4#list")
                .method("GET", null)
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .addHeader("Accept-Language", "en-US,en;q=0.5")
                .addHeader("Referer", "https://hidemy.name/es/proxy-list/")
                .addHeader("DNT", "1")
                .addHeader("Connection", "keep-alive")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("TE", "Trailers")
                .build();

        return Optional.of(Objects.requireNonNull(client.newCall(request).execute().body()).string()).orElse("");
    }
}
