package com.example.consumingrest.service;

import com.example.consumingrest.proxy.Value;
import com.example.consumingrest.proxy.QuotesProxy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class QuotesService {

    private final QuotesProxy quotesProxyClient;

    private final QuotesMapper quotesMapper;


    public QuotesService(QuotesProxy quotesProxyClient, QuotesMapper quotesMapper) {
        this.quotesProxyClient = quotesProxyClient;
        this.quotesMapper = quotesMapper;
    }

    public String fetchAllData() {
        String quote = fetchAllDataFromLocalHost();
        return quote;
    }

    private String fetchAllDataFromLocalHost() {
        String jsonQuotes = quotesProxyClient.makeGetRequest();
        if (jsonQuotes == null) {
            log.error("json was null");
            return "";
        }
        Value value = quotesMapper.mapJsonValueResponse(jsonQuotes);
        log.info("ConsumingRestService fetched: " + value);
        return value.quote();
    }
}
