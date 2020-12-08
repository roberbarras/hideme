package com.proxy.hideme.service.impl;

import com.proxy.hideme.entity.ProxyEntity;
import com.proxy.hideme.repository.ProxyRepository;
import com.proxy.hideme.service.ProxyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProxyServiceImpl implements ProxyService {

    private final ProxyRepository proxyRepository;

    public ProxyServiceImpl(ProxyRepository proxyRepository) {
        this.proxyRepository = proxyRepository;
    }

    @Override
    public void save(ProxyEntity proxyEntity) {
        proxyRepository.save(proxyEntity);
    }

    @Override
    public void save(List<ProxyEntity> proxyEntityList) {
        proxyRepository.saveAll(proxyEntityList);
    }

}
