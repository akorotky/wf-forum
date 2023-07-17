package com.webforum.forum.repository;

import com.webforum.forum.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

    @Query("SELECT * FROM category LIMIT :#{#pageable.pageSize} OFFSET :#{#pageable.offset}")
    Flux<Category> findAll(Pageable pageable);

    @Query("SELECT c.* FROM category c INNER JOIN category_relation cr ON c.id = cr.child_category_id WHERE cr.category_id = :categoryId")
    Flux<Category> findAllSubcategoriesByCategoryId(Long categoryId);

    @Query("SELECT c.* FROM category c INNER JOIN category_relation cr ON c.id = cr.parent_category_id WHERE cr.child_category_id = :categoryId")
    Flux<Category> findParentCategoryByCategoryId(Long categoryId);
}
