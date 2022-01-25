package com.maocq.api;

import com.maocq.usecase.validateidentityauthentic.ValidateIdentityAuthenticUseCase;
import com.maocq.usecase.validateidentityiseries.ValidateIdentityISeriesUseCase;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CircuitBreakerHandler {

    private final ValidateIdentityISeriesUseCase validateIdentityISeriesUseCase;
    private final ValidateIdentityAuthenticUseCase validateIdentityAuthenticUseCase;

    @CircuitBreaker(name = "validateIdentityService", fallbackMethod = "somethingFallback")
    public Mono<String> handle(String text) {
        return validateIdentityISeriesUseCase.handle(text);
    }

    public Mono<String> somethingFallback(String text, Exception exception) {
        return validateIdentityAuthenticUseCase.handle(text + " error -> " + exception.getMessage());
    }
}
