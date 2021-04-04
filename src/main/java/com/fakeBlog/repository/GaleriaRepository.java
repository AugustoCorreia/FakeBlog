package com.fakeBlog.repository;

import com.fakeBlog.entity.GaleriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleriaRepository extends JpaRepository<GaleriaEntity,Long> {
}
