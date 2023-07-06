package com.webforum.forum.api.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PostRouter {

    @Bean
    public RouterFunction<ServerResponse> routePosts(PostHandler postHandler) {
        return RouterFunctions.route()
                .path("/posts", builder -> builder
                        .GET(postHandler::getAllPosts)
                        .POST(postHandler::createPost)
                        .GET("{id}", postHandler::getPost)
                        .PATCH("{id}", postHandler::updatePost)
                        .DELETE("{id}", postHandler::deletePost)
                )
                .build();
    }
}
