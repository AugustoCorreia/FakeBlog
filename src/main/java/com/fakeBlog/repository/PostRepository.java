package com.fakeBlog.repository;

import com.fakeBlog.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <PostEntity,Long> {
	@Query(value = "SELECT * FROM post p WHERE " +
            "p.titulo like %:search% " +
            "or p.texto like %:search%", nativeQuery = true)
    Page<PostEntity> search(Pageable pageable,@Param("search") String search);
}
