package com.fakeBlog.services;

import com.fakeBlog.entity.ComentarioEntity;
import com.fakeBlog.entity.PostEntity;
import com.fakeBlog.mapper.ComentarioMapper;
import com.fakeBlog.model.ComentarioRequest;
import com.fakeBlog.model.PostRequest;
import com.fakeBlog.repository.ComentarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioService implements IComentarioService{

    private ComentarioRepository repository;

    private ComentarioMapper mapper;

    @Override
    public Page<ComentarioEntity> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ResponseEntity<ComentarioEntity> getById(Long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record
                )).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ComentarioEntity> create(ComentarioRequest request) {
        return ResponseEntity.ok().body(
                repository.save(
                        mapper.mapRequestToEntity(request)
                ));
    }

    @Override
    public ResponseEntity<ComentarioEntity> update(ComentarioRequest request, Long id) {
        return repository.findById(id)
                .map(record -> {
                    ComentarioEntity updated = mapper.mapRequestToUpdateEntity(request,record) ;
                    return ResponseEntity.ok().body(
                            repository.save(updated)
                    );
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ComentarioEntity> delete(Long id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
