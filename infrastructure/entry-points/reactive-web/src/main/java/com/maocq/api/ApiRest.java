package com.maocq.api;
import com.maocq.usecase.validateidentityiseries.ValidateIdentityISeriesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;

    private final CircuitBreakerHandler circuitBreakerHandler;
    private final ValidateIdentityISeriesUseCase validateIdentityISeriesUseCase;

    @GetMapping(path = "/path")
    public Mono<String> commandName() {
//      return useCase.doAction();
        return Mono.just("Hello World");
    }

    @GetMapping(path = "/ncb/{id}")
    public Mono<String> ncb(@PathVariable String id) {
        return validateIdentityISeriesUseCase.handle(id);
    }

    @GetMapping(path = "/cb/{id}")
    public Mono<String> cb(@PathVariable String id) {
        return circuitBreakerHandler.handle(id);
    }
}
