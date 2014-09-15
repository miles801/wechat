package com.miles.http;

/**
 * Created by Michael on 2014/9/15.
 */
public class HttpProxyRequest implements HttpRequest {
    public HttpProxyRequest(HttpProxy proxy)
    {
        this.proxy = proxy;
    }

    public String doExecute(String url)
    {
        return null;
    }

    private HttpProxy proxy;
}
