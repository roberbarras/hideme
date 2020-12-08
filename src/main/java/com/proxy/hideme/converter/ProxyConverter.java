package com.proxy.hideme.converter;

import com.proxy.hideme.entity.ProxyEntity;
import com.proxy.hideme.model.Proxy;

/**
 * Utility class to convert Proxy to ProxyEntity and vice versa
 */
public class ProxyConverter {

    private ProxyConverter() {
        throw new IllegalStateException("Converter class");
    }

    /**
     * Method to convert Proxy to ProxyEntity
     * @param proxy Proxy to convert
     * @return ProxyEntity already converted
     */
    public static ProxyEntity toEntity(Proxy proxy) {
        return new ProxyEntity()
                .ip(proxy.getIp())
                .port(proxy.getPort())
                .country(proxy.getCountry())
                .response(proxy.getResponse())
                .type(proxy.getType())
                .security(proxy.getSecurity())
                .updated(proxy.getUpdated())
                .build();
    }

    /**
     * Method to convert ProxyEntity to Proxy
     * @param proxyEntity ProxyEntity to convert
     * @return Proxy already converted
     */
    public static Proxy toModel(ProxyEntity proxyEntity) {
        return new Proxy()
                .ip(proxyEntity.getIp())
                .port(proxyEntity.getPort())
                .country(proxyEntity.getCountry())
                .response(proxyEntity.getResponse())
                .type(proxyEntity.getType())
                .security(proxyEntity.getSecurity())
                .updated(proxyEntity.getUpdated())
                .build();
    }
}
