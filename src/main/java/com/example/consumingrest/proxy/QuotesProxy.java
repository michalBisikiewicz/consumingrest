package com.example.consumingrest.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class QuotesProxy {
    //to jest do poprawy , sprawdzić czemu nie działa
    @Autowired
    RestTemplate restTemplate;

    @org.springframework.beans.factory.annotation.Value("${quotes-server.service.url}")
    String url;

    @org.springframework.beans.factory.annotation.Value("${quotes-server.service.port}")
    int port;

    public String makeGetRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/api");
        Quote requestBody = new Quote("success", new Value(1L, "Testing GET request"));
        HttpEntity<Quote> httpEntity = new HttpEntity<>(requestBody);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    httpEntity,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            System.out.println(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
