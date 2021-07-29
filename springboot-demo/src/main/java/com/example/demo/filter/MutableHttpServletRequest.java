package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public final class MutableHttpServletRequest extends HttpServletRequestWrapper {

    private final Map<String, String> customHeaders;

    public MutableHttpServletRequest(HttpServletRequest request) {

        super(request);

        this.customHeaders = new HashMap<>();

    }

    /**
     * 往header中添加参数
     *
     * @param key   键
     * @param value 值
     */

    public void putHeader(String key, String value) {

        this.customHeaders.put(key, value);

    }

    @Override

    public String getHeader(String key) {

        String headerValue = customHeaders.get(key);

        if (headerValue != null) {

            return headerValue;

        }

        return ((HttpServletRequest) getRequest()).getHeader(key);

    }

    @Override

    public Enumeration<String> getHeaderNames() {

        Set<String> set = new HashSet<>(customHeaders.keySet());

        @SuppressWarnings("unchecked")

        Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();

        while (e.hasMoreElements()) {

            String n = e.nextElement();

            set.add(n);

        }

        return Collections.enumeration(set);

    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        Enumeration<String> headers = super.getHeaders(name);

        Set<String> set = new HashSet<>();

        while (headers.hasMoreElements()) {

            String n = headers.nextElement();

            set.add(n);

        }

        set.add(getHeader(name));

        return Collections.enumeration(set);
    }

}