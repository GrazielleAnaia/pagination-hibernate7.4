package com.productionready.blog.controller;

import com.productionready.blog.dto.PostResponse;
import com.productionready.blog.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostResponse> findAll(
            @RequestParam(defaultValue = "100") int minUpvotes,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.findSimplePage(minUpvotes, PageRequest.of(page, size));
    }
}
