package com.webforum.forum.api.tag;

import com.webforum.forum.entity.Tag;
import com.webforum.forum.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.webforum.forum.util.HandlerUtils.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor
public class TagHandler {

    private final TagService tagService;

    public Mono<ServerResponse> getAllTags(ServerRequest request) {
        Pageable pageable = extractPaginationFromRequest(request);
        return ok()
                .contentType(APPLICATION_JSON)
                .body(tagService.findAllTags(pageable), Tag.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getTag(ServerRequest request) {
        return tagService.findTagById(extractPathVariableId(request))
                .flatMap(tag -> ok().contentType(APPLICATION_JSON).bodyValue(tag))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createTag(ServerRequest request) {
        return request.bodyToMono(Tag.class)
                .flatMap(tagService::createTag)
                .flatMap(tag -> created(getCreatedEntityUri(request, tag.getId())).build());
    }

    public Mono<ServerResponse> updateTag(ServerRequest request) {
        return request.bodyToMono(Tag.class)
                .flatMap(tagService::updateTag).flatMap(v -> noContent().build());
    }

    public Mono<ServerResponse> deleteTag(ServerRequest request) {
        return tagService.deleteTagById(extractPathVariableId(request))
                .flatMap(v -> noContent().build());
    }
}
