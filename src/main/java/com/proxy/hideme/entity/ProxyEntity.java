package com.proxy.hideme.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "proxy")
@IdClass(ProxyEntityId.class)
public class ProxyEntity {

    @Id
    @Column(length = 15, nullable = false)
    private String ip;

    @Id
    @Column(nullable = false)
    private int port;

    @Column
    private String country;

    @Column(nullable = false)
    private int response;

    @Id
    @Column(nullable = false)
    private String type;

    @Column
    private String security;

    @Column
    private int updated;

    @Column
    private LocalDateTime creationDate;

    public ProxyEntity ip(String ip) {
        this.ip = ip;
        return this;
    }

    public ProxyEntity port(int port) {
        this.port = port;
        return this;
    }

    public ProxyEntity country(String country) {
        this.country = country;
        return this;
    }

    public ProxyEntity response(int response) {
        this.response = response;
        return this;
    }

    public ProxyEntity type(String type) {
        this.type = type;
        return this;
    }

    public ProxyEntity security(String security) {
        this.security = security;
        return this;
    }

    public ProxyEntity updated(int updated) {
        this.updated = updated;
        return this;
    }

    public ProxyEntity build() {
        return new ProxyEntity(ip, port, country, response, type, security, updated);
    }

    public ProxyEntity() {
    }

    public ProxyEntity(String ip, int port, String country, int response, String type, String security, int updated) {
        this.ip = ip;
        this.port = port;
        this.country = country;
        this.response = response;
        this.type = type;
        this.security = security;
        this.updated = updated;
        this.creationDate = LocalDateTime.now();
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getCountry() {
        return country;
    }

    public int getResponse() {
        return response;
    }

    public String getType() {
        return type;
    }

    public String getSecurity() {
        return security;
    }

    public int getUpdated() {
        return updated;
    }
}
