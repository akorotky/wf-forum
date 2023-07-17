package com.webforum.forum.service;

import com.webforum.forum.entity.Post;
import com.webforum.forum.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Flux<Post> findAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Mono<Post> findPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public Mono<Post> createPost(Post post) {
        return postRepository.save(post);
    }

    public Mono<Post> updatePost(Post post) {
        return postRepository.save(post);
    }

    public Mono<Void> deletePostById(Long postId) {
        return postRepository.deleteById(postId);
    }
}
