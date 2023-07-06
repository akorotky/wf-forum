package com.webforum.forum.api.thread;

import com.webforum.forum.entity.Thread;
import com.webforum.forum.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.webforum.forum.util.HandlerUtils.*;
import static com.webforum.forum.util.HandlerUtils.extractPathVariableId;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.*;
import static org.springframework.web.reactive.function.server.ServerResponse.noContent;

@Component
@RequiredArgsConstructor
public class ThreadHandler {

    private final ThreadService threadService;

    public Mono<ServerResponse> getAllThreads(ServerRequest request) {
        Pageable pageable = extractPaginationFromRequest(request);
        return ok()
                .contentType(APPLICATION_JSON)
                .body(threadService.findAllThreads(pageable), Thread.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getThread(ServerRequest request) {
        return threadService.findThreadById(extractPathVariableId(request))
                .flatMap(thread -> ok().contentType(APPLICATION_JSON).bodyValue(thread))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createThread(ServerRequest request) {
        return request.bodyToMono(Thread.class)
                .flatMap(threadService::createThread)
                .flatMap(thread -> created(getCreatedEntityUri(request, thread.getId())).build());
    }

    public Mono<ServerResponse> updateThread(ServerRequest request) {
        return request.bodyToMono(Thread.class)
                .flatMap(threadService::updateThread).flatMap(v -> noContent().build());
    }

    public Mono<ServerResponse> deleteThread(ServerRequest request) {
        return threadService.deleteThreadById(extractPathVariableId(request))
                .flatMap(v -> noContent().build());
    }
}
