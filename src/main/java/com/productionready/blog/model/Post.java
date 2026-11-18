package com.productionready.blog.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "post_seq", allocationSize = 50)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Instant publishedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    protected Post() {}

    public Post(String title, String author, Instant publishedAt) {
        this.title = title;
        this.author = author;
        this.publishedAt = publishedAt;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Instant getPublishedAt() { return publishedAt; }
    public List<Comment> getComments() { return comments; }
}
