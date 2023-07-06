package com.webforum.forum.service;

import com.webforum.forum.entity.Thread;
import com.webforum.forum.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class ThreadService {

    private final ThreadRepository threadRepository;

    public Flux<Thread> findAllThreads(Pageable pageable) {
        return threadRepository.findAll(pageable);
    }

    public Mono<Thread> findThreadById(Long threadId) {
        return threadRepository.findById(threadId);
    }

    public Mono<Thread> createThread(Thread thread) {
        return threadRepository.save(thread);
    }

    public Mono<Thread> updateThread(Thread thread) {
        return threadRepository.save(thread);
    }

    public Mono<Void> deleteThreadById(Long threadId) {
        return threadRepository.deleteById(threadId);
    }
}
