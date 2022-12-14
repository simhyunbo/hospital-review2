package com.hospital.review2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Response<T> {

    private String resultCode;
    private T result;

    private static Response<Void> error(String resultCode) {
        return new Response(resultCode, null);
    }

    public static <T> Response<T> suceess(T result) {
        return new Response("SUCCESS", result);
    }

}
