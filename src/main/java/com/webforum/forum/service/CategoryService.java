package com.webforum.forum.service;

import com.webforum.forum.entity.Category;
import com.webforum.forum.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Flux<Category> findAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Mono<Category> findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public Mono<Category> createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Mono<Category> updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Mono<Void> deleteCategoryById(Long categoryId) {
        return categoryRepository.deleteById(categoryId);
    }
}
