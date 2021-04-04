package com.fakeBlog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FotosRequest {

    @NotNull
    private String url;
    @NotNull
    private Long user_id;

    private Long galeria_Id;
}
