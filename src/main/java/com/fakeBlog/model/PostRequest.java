package com.fakeBlog.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {
    @NotNull
    private String titulo;
    private String link;
    private String img;
    @NotNull
    private String texto;
    @NotNull
    private Long usuarioId;
}
