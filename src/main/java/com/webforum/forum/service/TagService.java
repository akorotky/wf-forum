package com.webforum.forum.service;

import com.webforum.forum.entity.Tag;
import com.webforum.forum.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Flux<Tag> findAllTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    public Mono<Tag> findTagById(Long tagId) {
        return tagRepository.findById(tagId);
    }

    public Mono<Tag> createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Mono<Tag> updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Mono<Void> deleteTagById(Long tagId) {
        return tagRepository.deleteById(tagId);
    }
}
