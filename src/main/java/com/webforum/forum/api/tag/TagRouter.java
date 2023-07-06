package com.webforum.forum.api.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TagRouter {

    @Bean
    public RouterFunction<ServerResponse> routeTags(TagHandler tagHandler) {
        return RouterFunctions.route()
                .path("/tags", builder -> builder
                        .GET(tagHandler::getAllTags)
                        .POST(tagHandler::createTag)
                        .GET("{id}", tagHandler::getTag)
                        .PATCH("{id}", tagHandler::updateTag)
                        .DELETE("{id}", tagHandler::deleteTag)
                )
                .build();
    }
}
