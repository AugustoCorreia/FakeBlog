package com.fakeBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
public class FotosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false,updatable = false)
    private Long user_id;

    @Column
    private Long galeria_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
}
