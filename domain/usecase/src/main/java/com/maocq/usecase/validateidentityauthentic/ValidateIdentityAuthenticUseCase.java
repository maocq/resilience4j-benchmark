package com.maocq.usecase.validateidentityauthentic;

import com.maocq.model.hash.Hash;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ValidateIdentityAuthenticUseCase {

    public Mono<String> handle(String text) {
        return Mono.just("Validate identity Authentic: " + text + " " + Hash.hash(text));
    }
}
