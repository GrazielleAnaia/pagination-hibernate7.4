package com.productionready.blog.config;

import com.productionready.blog.model.Comment;
import com.productionready.blog.model.Post;
import com.productionready.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);
    private final PostRepository postRepository;
    private final int postCount;

    public DataSeeder(PostRepository postRepository, @Value("${demo.seed.posts:1000}") int postCount) {
        this.postRepository = postRepository;
        this.postCount = postCount;
    }

    @Override
    @Transactional
    public void run(String... args) {
        Random random = new Random(42);
        List<Post> posts = new ArrayList<>(postCount);

        for (int i = 1; i <= postCount; i++) {
            Post post = new Post(
                    "System Design Deep Dive #" + i,
                    "Author_" + (1 + random.nextInt(50)),
                    Instant.now().minus(random.nextInt(365), ChronoUnit.DAYS)
            );

            int commentCount = 2 + random.nextInt(5); // 2 to 6 comments per post
            for (int j = 1; j <= commentCount; j++) {
                post.addComment(new Comment(
                        "Great point on database indexing #" + j,
                        random.nextInt(250) // 0 to 249 upvotes
                ));
            }
            posts.add(post);
        }
        postRepository.saveAll(posts);
        log.info("Seeded {} blog posts with comments", postCount);
    }
}

