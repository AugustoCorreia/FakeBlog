package com.fakeBlog.controllers;

import com.fakeBlog.model.GaleriaRequest;
import com.fakeBlog.services.GaleriaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(name = "Galeria API", value = "/galerias")
public class GaleiriaController {

    private GaleriaService service;

    @GetMapping
    public Page<?> getAll(
            @RequestHeader(value="Authorization") String auth,
            @RequestParam(required = true, value = "page") Integer page,
            @RequestParam(required = true, value = "size") Integer size) {
        return service.getAll(PageRequest.of(page, size));
    }

    @GetMapping("/Galeria")
    public ResponseEntity<?> getById(
            @RequestHeader(value="Authorization") String auth,
            @RequestParam(value = "id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestHeader(value="Authorization") String auth,
            @RequestBody @Valid GaleriaRequest request){
        return service.create(request);
    }

    @PutMapping
    public ResponseEntity<?> update(
            @RequestHeader(value="Authorization") String auth,
            @RequestBody @Valid GaleriaRequest request,
            @RequestParam(value ="id") Long id){
        return service.update(request,id);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestHeader(value="Authorization") String auth,
            @RequestParam("id") Long id){
        return service.delete(id);
    }

}
