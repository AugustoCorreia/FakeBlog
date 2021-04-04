package com.fakeBlog.services;

import com.fakeBlog.entity.GaleriaEntity;
import com.fakeBlog.mapper.GaleriaMapper;
import com.fakeBlog.model.GaleriaRequest;
import com.fakeBlog.repository.GaleriaRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class GaleriaService  implements IGaleriaService{

    private GaleriaRepository repository;

    private GaleriaMapper mapper;

    @Override
    public Page<?> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ResponseEntity<?> getById(Long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record
                )).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> create(GaleriaRequest request) {
        return ResponseEntity.ok().body(
                repository.save(
                        mapper.mapRequestToEntity(request)
                ));
    }

    @Override
    public ResponseEntity<?> update(GaleriaRequest request, Long id) {
        return repository.findById(id)
                .map(record -> {
                    GaleriaEntity updated = mapper.mapRequestToUpdateEntity(request,record) ;
                    return ResponseEntity.ok().body(
                            repository.save(updated)
                    );
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
