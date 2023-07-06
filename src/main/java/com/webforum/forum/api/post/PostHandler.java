package com.webforum.forum.api.post;

import com.webforum.forum.entity.Post;
import com.webforum.forum.service.PostService;
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
public class PostHandler {

    private final PostService postService;

    public Mono<ServerResponse> getAllPosts(ServerRequest request) {
        Pageable pageable = extractPaginationFromRequest(request);
        return ok()
                .contentType(APPLICATION_JSON)
                .body(postService.findAllPosts(pageable), Post.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getPost(ServerRequest request) {
        return postService.findPostById(extractPathVariableId(request))
                .flatMap(post -> ok().contentType(APPLICATION_JSON).bodyValue(post))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createPost(ServerRequest request) {
        return request.bodyToMono(Post.class)
                .flatMap(postService::createPost)
                .flatMap(post -> created(getCreatedEntityUri(request, post.getId())).build());
    }

    public Mono<ServerResponse> updatePost(ServerRequest request) {
        return request.bodyToMono(Post.class)
                .flatMap(postService::updatePost).flatMap(v -> noContent().build());
    }

    public Mono<ServerResponse> deletePost(ServerRequest request) {
        return postService.deletePostById(extractPathVariableId(request))
                .flatMap(v -> noContent().build());
    }
}
