package com.proxy.hideme.repository;

import com.proxy.hideme.entity.ProxyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ProxyRepository extends JpaRepository<ProxyEntity, Serializable> {
}
