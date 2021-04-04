package com.fakeBlog.services;

import com.fakeBlog.entity.PostEntity;
import com.fakeBlog.model.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IPostService {
    Page<PostEntity> getAll(Pageable pageable, String search);

    ResponseEntity<PostEntity> getById(Long id);

    ResponseEntity<PostEntity> create(PostRequest post);

    ResponseEntity<PostEntity> update(PostRequest post, Long id);

    ResponseEntity<PostEntity> delete(Long id);
}
