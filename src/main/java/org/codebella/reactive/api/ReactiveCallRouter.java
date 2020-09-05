package org.codebella.reactive.api;

import org.codebella.reactive.Stock;
import org.codebella.reactive.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ReactiveCallRouter {
    @Autowired
    private StockRepository repository;

    @Bean
    public RouterFunction<ServerResponse> composeRoutes(ReactiveCallHandler handler) {
        return RouterFunctions.route(GET("/name/{id}").and(accept(APPLICATION_JSON)), handler::get)
                .and(RouterFunctions.route(RequestPredicates.POST("/name"), req -> req.body(toMono(Stock.class))
                        .doOnNext(repository::save)
                        .then(ok().build())));
    }
}
