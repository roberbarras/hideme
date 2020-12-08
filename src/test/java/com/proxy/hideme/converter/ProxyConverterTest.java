package com.proxy.hideme.converter;

import com.proxy.hideme.entity.ProxyEntity;
import com.proxy.hideme.model.Proxy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProxyConverterTest {

    private Proxy proxy;
    private ProxyEntity proxyEntity;

    @BeforeEach
    void setUp() {
        proxy = new Proxy().ip("1.1.1.1")
                .port(1234)
                .updated(5)
                .type("HTTP")
                .country("Spain")
                .security("Alta")
                .response(200)
                .build();

        proxyEntity = new ProxyEntity().ip("2.2.2.2")
                .port(4321)
                .updated(4)
                .type("SOCKS4")
                .country("Italy")
                .security("Media")
                .response(400)
                .build();
    }

    @Test
    void toEntity() {
        ProxyEntity proxyEntity = ProxyConverter.toEntity(proxy);
        Assertions.assertEquals(proxy.getIp(), proxyEntity.getIp());
        Assertions.assertEquals(proxy.getPort(), proxyEntity.getPort());
        Assertions.assertEquals(proxy.getUpdated(), proxyEntity.getUpdated());
        Assertions.assertEquals(proxy.getType(), proxyEntity.getType());
        Assertions.assertEquals(proxy.getCountry(), proxyEntity.getCountry());
        Assertions.assertEquals(proxy.getSecurity(), proxyEntity.getSecurity());
        Assertions.assertEquals(proxy.getResponse(), proxyEntity.getResponse());
    }

    @Test
    void toModel() {
        Proxy proxy = ProxyConverter.toModel(proxyEntity);
        Assertions.assertEquals(proxy.getIp(), proxyEntity.getIp());
        Assertions.assertEquals(proxy.getPort(), proxyEntity.getPort());
        Assertions.assertEquals(proxy.getUpdated(), proxyEntity.getUpdated());
        Assertions.assertEquals(proxy.getType(), proxyEntity.getType());
        Assertions.assertEquals(proxy.getCountry(), proxyEntity.getCountry());
        Assertions.assertEquals(proxy.getSecurity(), proxyEntity.getSecurity());
        Assertions.assertEquals(proxy.getResponse(), proxyEntity.getResponse());
    }
}