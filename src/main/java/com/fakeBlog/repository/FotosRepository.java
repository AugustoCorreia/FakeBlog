package com.fakeBlog.repository;

import com.fakeBlog.entity.FotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotosRepository extends JpaRepository<FotosEntity,Long> {
}
