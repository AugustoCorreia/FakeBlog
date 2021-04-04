package com.fakeBlog.services;

import com.fakeBlog.entity.FotosEntity;
import com.fakeBlog.mapper.FotosMapper;
import com.fakeBlog.model.FotosRequest;
import com.fakeBlog.repository.FotosRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@NoArgsConstructor
public class FotosService implements IFotosService{

    private FotosRepository repository;

    private FotosMapper mapper;

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
    public ResponseEntity<?> create(FotosRequest request) {
        return ResponseEntity.ok().body(
                repository.save(
                        mapper.mapRequestToEntity(request)
                ));
    }

    @Override
    public ResponseEntity<?> update(FotosRequest request, Long id) {
        return repository.findById(id)
                .map(record -> {
                    FotosEntity updated = mapper.mapRequestToUpdateEntity(request,record) ;
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
