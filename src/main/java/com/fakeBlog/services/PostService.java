package com.fakeBlog.services;

import com.fakeBlog.entity.PostEntity;
import com.fakeBlog.mapper.PostMapper;
import com.fakeBlog.model.PostRequest;
import com.fakeBlog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PostService implements IPostService{

    private PostRepository repository;

    private PostMapper mapper;

    @Override
    public Page<PostEntity> getAll(Pageable pageable, String search) {
        return search.isEmpty()?
                repository.findAll(pageable):
                    repository.search(pageable, search);
    }

    @Override
    public ResponseEntity<PostEntity> getById(Long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record
                )).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PostEntity> create(PostRequest post) {
         return ResponseEntity.ok().body(
                repository.save(
                        mapper.mapRequestToPost(post)
        ));
    }

    @Override
    public ResponseEntity<PostEntity> update(PostRequest post, Long id) {
        return repository.findById(id)
                .map(record -> {
                    PostEntity postUpdated = mapper.mapRequestToUpdatePost(post,record) ;
                    return ResponseEntity.ok().body(
                            repository.save(postUpdated)
                    );
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<PostEntity> delete(Long id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
         repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
