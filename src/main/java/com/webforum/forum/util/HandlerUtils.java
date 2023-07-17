package com.webforum.forum.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class HandlerUtils {

    public static Pageable extractPaginationFromRequest(ServerRequest request) {
        int page = Integer.parseInt(request.queryParam("page").orElse("0"));
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));
        return PageRequest.of(page, size);
    }

    public static URI getCreatedEntityUri(ServerRequest request, Long id) {
        return UriComponentsBuilder.fromPath(request.path())
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    public static Long extractPathVariableId(ServerRequest request) {
        return Long.parseLong(request.pathVariable("id"));
    }
}
