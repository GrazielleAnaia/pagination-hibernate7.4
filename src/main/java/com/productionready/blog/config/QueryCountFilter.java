package com.productionready.blog.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class QueryCountFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(QueryCountFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        QueryCounter.reset();
        long start = System.currentTimeMillis();
        try {
            chain.doFilter(req, res);
        } finally {
            long ms = System.currentTimeMillis() - start;
            log.info("{} {}?{} -> {} queries in {} ms",
                    req.getMethod(), req.getRequestURI(), req.getQueryString(), QueryCounter.get(), ms);
            QueryCounter.reset();
        }
    }
}
