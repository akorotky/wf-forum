package com.webforum.forum.repository;

import com.webforum.forum.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {

    @Query("SELECT * FROM post LIMIT :#{#pageable.pageSize} OFFSET :#{#pageable.offset}")
    Flux<Post> findAll(Pageable pageable);
}
