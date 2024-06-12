package com.example.consumingrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ConsumingRestApplication {

    @Autowired
    MainApplicationRunner mainApplicationRunner;
//    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

//    @Bean
//    @Profile("!test")
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            Quote quote = restTemplate.getForObject(
//                    "http://localhost:8081/api/random", Quote.class);
//            log.info(quote.toString());
//        };
//    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        mainApplicationRunner.start();
    }
}
