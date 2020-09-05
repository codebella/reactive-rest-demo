package org.codebella.reactive.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ReactiveCallHandler implements HandlerFunction {

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Retrieved, Spring!"));
    }

    public Mono<ServerResponse> post(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Created, Spring!"));
    }

    public Mono<ServerResponse> put(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Replaced, Spring!"));
    }

    public Mono<ServerResponse> patch(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Patched, Spring!"));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Deleted, Spring!"));
    }

    @Override
    public Mono handle(ServerRequest request) {
        return null;
    }
}
