package com.productionready.blog.service;


import com.productionready.blog.dto.PostResponse;
import com.productionready.blog.repository.PostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<PostResponse> findSimplePage(int minUpvotes, Pageable pageable) {
        return posts.findAllWithCommentsSimple(minUpvotes, pageable).stream()
                .map(PostResponse::from)
                .toList();
    }
}
