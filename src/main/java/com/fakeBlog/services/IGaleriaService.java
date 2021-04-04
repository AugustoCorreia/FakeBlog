package com.fakeBlog.services;

import com.fakeBlog.model.GaleriaRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IGaleriaService {

    Page<?> getAll(Pageable pageable);

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> create(GaleriaRequest request);

    ResponseEntity<?> update(GaleriaRequest request, Long id);

    ResponseEntity<?> delete(Long id);
}
