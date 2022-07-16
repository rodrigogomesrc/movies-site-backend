package br.ufrn.imd.moviessitebackend.util;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

public class HttpRequests {

    public static ResponseEntity<String> post(String url, String data, Map<String, String> requestHeaders) {
        return httpRequest(url, HttpMethod.POST, data, requestHeaders);
    }

    public static ResponseEntity<String> get(String url, Map<String, String> requestHeaders) {
        return httpRequest(url, HttpMethod.GET, null, requestHeaders);
    }

    public static ResponseEntity<String> delete(String url, Map<String, String> requestHeaders) {
        return httpRequest(url, HttpMethod.DELETE, null, requestHeaders);
    }

    private static ResponseEntity<String> httpRequest(
            String url, HttpMethod method, String data, Map<String, String> requestHeaders) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = getHeaders(requestHeaders);
        HttpEntity<String> entity;
        if(method == HttpMethod.POST || method == HttpMethod.PUT) {
            entity = new HttpEntity<>(data, headers);
            try {
                return restTemplate.exchange(url, method, entity, String.class);
            } catch (HttpClientErrorException e) {
                return new ResponseEntity<>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getStatusCode());
            }
        }
        entity = new HttpEntity<>(headers);
        try {
            return restTemplate.exchange(url, method, entity, String.class);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getStatusCode());
        }
    }

    private static HttpHeaders getHeaders(Map<String, String> requestHeaders) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(requestHeaders);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        return headers;
    }

}