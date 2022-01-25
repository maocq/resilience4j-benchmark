package com.maocq.usecase.validateidentityiseries;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
public class ValidateIdentityISeriesUseCase {

    public Mono<String> handle(String text) {
        return Mono.defer(() -> {
            System.out.println("*** Validating identity iSeries: " + text + " ***");

            if (text.equals("error"))
                return Mono.error(new IllegalStateException("Bumm!"));

            if (text.equals("timeout"))
                return Mono.just("Slow validate identity iSeries  " + text).delayElement(Duration.ofSeconds(3));

            return Mono.just("Validate identity iSeries " + text);
        });
    }
}
