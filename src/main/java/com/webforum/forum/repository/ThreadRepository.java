package com.webforum.forum.repository;

import com.webforum.forum.entity.Thread;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends ReactiveCrudRepository<Thread, Long> {
}
