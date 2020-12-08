package com.proxy.hideme;


import com.proxy.hideme.converter.ProxyConverter;
import com.proxy.hideme.mapper.ProxyMapper;
import com.proxy.hideme.model.Proxy;
import com.proxy.hideme.service.ProxyService;
import com.proxy.hideme.service.RequestService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MainTask {

    @Autowired private RequestService requestService;

    @Autowired private ProxyService proxyService;

    @Scheduled(fixedDelay = 60000)
    public void mainTask() throws IOException {

        //Send request
        String response = requestService.sendRequest();

        //Parse request with Jsoup
        Element element = Jsoup.parse(response)
                .select("tbody").stream()
                .findFirst().orElseThrow(() -> new RuntimeException("No elements found"));

        //Map to Proxy
        List<Proxy> collect = element.childNodes().stream()
                .parallel()
                .map(ProxyMapper::mapper)
                .sorted(Comparator.comparing(Proxy::getResponse))
                .collect(Collectors.toList());

        //Save
        proxyService.save(
                collect.stream()
                        .map(ProxyConverter::toEntity)
                        .collect(Collectors.toList())
        );
    }
}
