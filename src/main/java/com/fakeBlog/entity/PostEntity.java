package com.fakeBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;

    @Column(nullable = false)
    private String titulo;

    private String img;

    @Column(nullable = false)
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(nullable = false)
    private Long usuarioId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    private List<ComentarioEntity> comentarios;

}
