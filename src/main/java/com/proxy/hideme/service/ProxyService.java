package com.proxy.hideme.service;

import com.proxy.hideme.entity.ProxyEntity;

import java.util.List;

public interface ProxyService {

    void save(ProxyEntity proxyEntity);

    void save(List<ProxyEntity> proxyEntityList);
}
