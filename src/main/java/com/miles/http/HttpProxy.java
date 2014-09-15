package com.miles.http;

/**
 * Http代理
 * Created by Michael on 2014/9/15.
 */
public interface HttpProxy {
    String getHost();

    int getPort();

    String getUsername();

    String getPassword();
}
