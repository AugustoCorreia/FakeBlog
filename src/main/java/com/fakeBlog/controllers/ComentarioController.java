package com.fakeBlog.controllers;

import com.fakeBlog.entity.ComentarioEntity;
import com.fakeBlog.model.ComentarioRequest;
import com.fakeBlog.services.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(name = "ComentarioController", value = "/coments")
@AllArgsConstructor
@CrossOrigin
public class ComentarioController {

    private ComentarioService service;

    @GetMapping
    public Page<ComentarioEntity> getAllComentarios(
            @RequestHeader(value="Authorization") String auth,
            @RequestParam(required = true, value = "pageC") Integer page,
            @RequestParam(required = true, value = "sizeC") Integer size) {
        return service.getAll(PageRequest.of(page, size));
    }
    //	 TEM UM ERRO QUE DÁ NO PATHVARIABLE QUANDO VAI GERAR O SWAGGER

    @GetMapping("/comentario")
    public ResponseEntity<ComentarioEntity> getComentarioById(
            @RequestHeader(value="Authorization") String auth,
            @RequestParam(value = "idC") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<ComentarioEntity> createComentario(
            @RequestHeader(value="Authorization") String auth,
            @RequestBody @Valid ComentarioRequest request){
        return service.create(request);
    }

    @PutMapping
    public ResponseEntity<ComentarioEntity> updateComentario(
            @RequestHeader(value="Authorization") String auth,
            @RequestBody @Valid ComentarioRequest request,
            @RequestParam(value ="idC") Long id){
        return service.update(request,id);
    }

    @DeleteMapping
    public ResponseEntity<ComentarioEntity> deleteComentario(
            @RequestHeader(value="Authorization") String auth,
            @RequestParam("idC") Long id){
        return service.delete(id);
    }

}
