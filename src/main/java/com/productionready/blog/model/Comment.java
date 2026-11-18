package com.productionready.blog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", allocationSize = 50)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int upvotes;

    protected Comment() {}

    public Comment(String content, int upvotes) {
        this.content = content;
        this.upvotes = upvotes;
    }

    void setPost(Post post) { this.post = post; }
    public Long getId() { return id; }
    public String getContent() { return content; }
    public int getUpvotes() { return upvotes; }
}
