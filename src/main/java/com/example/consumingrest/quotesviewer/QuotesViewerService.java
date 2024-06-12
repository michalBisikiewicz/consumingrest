package com.example.consumingrest.quotesviewer;

import com.example.consumingrest.service.QuotesService;
import org.springframework.stereotype.Service;

@Service
public class QuotesViewerService {

    //sprawdzić czy jest dobre proxy
    private final QuotesService quotesService;

    public QuotesViewerService(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    public String viewAllQuotes() {
        return quotesService.fetchAllData();
    }
}
