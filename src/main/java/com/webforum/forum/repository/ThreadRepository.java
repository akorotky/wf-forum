package com.webforum.forum.repository;

import com.webforum.forum.entity.Thread;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ThreadRepository extends ReactiveCrudRepository<Thread, Long> {

    @Query("SELECT * FROM thread LIMIT :#{#pageable.pageSize} OFFSET :#{#pageable.offset}")
    Flux<Thread> findAll(Pageable pageable);
}
