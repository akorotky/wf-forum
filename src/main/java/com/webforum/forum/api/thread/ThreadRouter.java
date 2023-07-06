package com.webforum.forum.api.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ThreadRouter {

    @Bean
    public RouterFunction<ServerResponse> routeThreads(ThreadHandler threadHandler) {
        return RouterFunctions.route()
                .path("/threads", builder -> builder
                        .GET(threadHandler::getAllThreads)
                        .POST(threadHandler::createThread)
                        .GET("{id}", threadHandler::getThread)
                        .PATCH("{id}", threadHandler::updateThread)
                        .DELETE("{id}", threadHandler::deleteThread)
                )
                .build();
    }
}
