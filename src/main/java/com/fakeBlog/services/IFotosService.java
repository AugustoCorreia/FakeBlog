package com.fakeBlog.services;

import com.fakeBlog.model.FotosRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IFotosService {
    Page<?> getAll(Pageable pageable);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> create(FotosRequest request);

    ResponseEntity<?> update(FotosRequest request, Long id);

    ResponseEntity<?> delete(Long id);
}
