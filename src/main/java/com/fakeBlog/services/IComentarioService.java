package com.fakeBlog.services;

import com.fakeBlog.entity.ComentarioEntity;
import com.fakeBlog.model.ComentarioRequest;
import com.fakeBlog.model.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IComentarioService {
    Page<ComentarioEntity> getAll(Pageable pageable);

    ResponseEntity<ComentarioEntity> getById(Long id);

    ResponseEntity<ComentarioEntity> create(ComentarioRequest request);

    ResponseEntity<ComentarioEntity> update(ComentarioRequest request, Long id);

    ResponseEntity<ComentarioEntity> delete(Long id);
}
