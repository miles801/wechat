package com.miles.http;

import java.io.Serializable;

/**
 * 请求类型
 * Created by Michael on 2014/9/15.
 */
public class ContentType implements Serializable {
    public ContentType() {
    }

    private static final long serialVersionUID = -7768694718232371896L;
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String APPLICATION_XML = "application/xml";
    public static final String TEXT_HTML = "text/html";
    public static final String TEXT_XML = "text/xml";
}
