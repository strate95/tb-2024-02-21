package com.ll.domain;

import com.ll.standard_util.Ut;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String order;
    private String action;
    private String queryString;
    private Map<String, String> paramsMap;

    public Rq(String order) {
        paramsMap = new HashMap<>();

        this.order = order;

        String[] orderBits = order.split("\\?", 2);
        action = orderBits[0].trim();
        if (orderBits.length == 1) {
            return;
        }
        queryString = orderBits[1].trim();

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];
            paramsMap.put(paramName, paramValue);
        }
    }

    public String getAction() {
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        return Ut.str.parseInt(paramsMap.get(paramName), defaultValue);
    }
}
