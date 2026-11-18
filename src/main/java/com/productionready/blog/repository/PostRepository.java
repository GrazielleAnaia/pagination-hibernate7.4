package com.productionready.blog.repository;

import com.productionready.blog.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
        select p from Post p
        left join fetch p.comments c where c.upvotes >= :minUpvotes
        order by p.id, c.upvotes desc
        """)
    List<Post> findAllWithCommentsSimple(@Param("minUpvotes") int minUpvotes, Pageable pageable);
}
