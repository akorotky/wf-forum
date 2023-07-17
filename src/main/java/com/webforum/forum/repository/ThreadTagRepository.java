package com.webforum.forum.repository;

import com.webforum.forum.entity.ThreadTag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadTagRepository extends ReactiveCrudRepository<ThreadTag, Long> {
}
