package com.proxy.hideme.model;

public class Proxy {
    private String ip;
    private int port;
    private String country;
    private int response;
    private String type;
    private String security;
    private int updated;

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

    public Proxy ip (String ip){
        this.ip = ip;
        return this;
    }

    public Proxy port (int port){
        this.port = port;
        return this;
    }

    public Proxy country (String country){
        this.country = country;
        return this;
    }

    public Proxy response (int response){
        this.response = response;
        return this;
    }

    public Proxy type (String type){
        this.type = type;
        return this;
    }

    public Proxy security (String security){
        this.security = security;
        return this;
    }

    public Proxy updated (int updated) {
        this.updated = updated;
        return this;
    }

    public Proxy build() {
        return new Proxy(ip, port, country, response, type, security, updated);
    }

    public Proxy(String ip, int port, String country, int response, String type, String security, int updated) {
        this.ip = ip;
        this.port = port;
        this.country = country;
        this.response = response;
        this.type = type;
        this.security = security;
        this.updated = updated;
    }

    public Proxy() {
    }
}
