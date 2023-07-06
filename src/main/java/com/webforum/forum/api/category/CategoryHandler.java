package com.webforum.forum.api.category;

import com.webforum.forum.entity.Category;
import com.webforum.forum.service.CategoryService;
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
public class CategoryHandler {

    private final CategoryService categoryService;

    public Mono<ServerResponse> getAllCategories(ServerRequest request) {
        Pageable pageable = extractPaginationFromRequest(request);
        return ok()
                .contentType(APPLICATION_JSON)
                .body(categoryService.findAllCategories(pageable), Category.class)
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> getCategory(ServerRequest request) {
        return categoryService.findCategoryById(extractPathVariableId(request))
                .flatMap(category -> ok().contentType(APPLICATION_JSON).bodyValue(category))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> createCategory(ServerRequest request) {
        return request.bodyToMono(Category.class)
                .flatMap(categoryService::createCategory)
                .flatMap(category -> created(getCreatedEntityUri(request, category.getId())).build());
    }

    public Mono<ServerResponse> updateCategory(ServerRequest request) {
        return request.bodyToMono(Category.class)
                .flatMap(categoryService::updateCategory).flatMap(v -> noContent().build());
    }

    public Mono<ServerResponse> deleteCategory(ServerRequest request) {
        return categoryService.deleteCategoryById(extractPathVariableId(request))
                .flatMap(v -> noContent().build());
    }
}
