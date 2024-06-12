package com.example.consumingrest;

import com.example.consumingrest.quotesviewer.QuotesViewerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MainApplicationRunner {

    private final QuotesViewerService quotesViewerService;

    public MainApplicationRunner(QuotesViewerService quotesViewerService) {
        this.quotesViewerService = quotesViewerService;
    }

    public void start() {
        String quote = quotesViewerService.viewAllQuotes();
        log.info(quote);
    }
}
