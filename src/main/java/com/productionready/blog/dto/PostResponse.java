package com.productionready.blog.dto;

import com.productionready.blog.model.Post;

import java.time.Instant;
import java.util.List;

public record PostResponse(Long id,
                           String title,
                           String author,
                           Instant publishedAt,
                           List<CommentDto> comments) {

    public record CommentDto(Long id, String content, int upvotes) {}

    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getAuthor(),
                post.getPublishedAt(),
                post.getComments().stream()
                        .map(c -> new CommentDto(c.getId(), c.getContent(), c.getUpvotes()))
                        .toList()
        );
    }
}
