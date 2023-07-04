package com.webforum.forum.repository;

import com.webforum.forum.entity.Tag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends ReactiveCrudRepository<Tag, Long> {
}
