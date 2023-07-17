package com.webforum.forum.repository;

import com.webforum.forum.entity.CategoryRelation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRelationRepository extends ReactiveCrudRepository<CategoryRelation, Long> {
}
