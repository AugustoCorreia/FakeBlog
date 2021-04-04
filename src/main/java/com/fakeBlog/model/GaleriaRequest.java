package com.fakeBlog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaleriaRequest {

    @NotNull
    private String titulo;
    @NotNull
    private Long user_id;

}
