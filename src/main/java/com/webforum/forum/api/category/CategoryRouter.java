package com.webforum.forum.api.category;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CategoryRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCategories(CategoryHandler categoryHandler) {
        return RouterFunctions.route()
                .path("/categories", builder -> builder
                        .GET(categoryHandler::getAllCategories)
                        .POST(categoryHandler::createCategory)
                        .GET("{id}", categoryHandler::getCategory)
                        .PATCH("{id}", categoryHandler::updateCategory)
                        .DELETE("{id}", categoryHandler::deleteCategory)
                )
                .build();
    }
}
