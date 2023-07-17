package com.webforum.forum.repository;

import com.webforum.forum.entity.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TagRepository extends ReactiveCrudRepository<Tag, Long> {

    @Query("SELECT * FROM tag LIMIT :#{#pageable.pageSize} OFFSET :#{#pageable.offset}")
    Flux<Tag> findAll(Pageable pageable);
}
