package com.fakeBlog.controllers;

import com.fakeBlog.entity.PostEntity;
import com.fakeBlog.model.PostRequest;
import com.fakeBlog.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(
		name = "Post Controller",
		value = "/posts"
)
@CrossOrigin
@AllArgsConstructor
public class PostController {

	private PostService service;

	@GetMapping
	public Page<PostEntity> getAllPosts(
			@RequestHeader(value="Authorization") String auth,
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "size") Integer size,
			@RequestParam(value = "search", defaultValue = "") String search) {
		return service.getAll(PageRequest.of(page, size),search);
	}
//	 TEM UM ERRO QUE DÁ NO PATHVARIABLE QUANDO VAI GERAR O SWAGGER
	@GetMapping("/post")
	public ResponseEntity<PostEntity> getPostById(
			@RequestHeader(value="Authorization") String auth,
			@RequestParam(value = "id") Long id) {
		return service.getById(id);
	}
	@PostMapping
	public ResponseEntity<PostEntity> createPost(
			@RequestHeader(value="Authorization") String auth,
			@RequestBody @Valid PostRequest post){
		return service.create(post);
	}

	@PutMapping
	public ResponseEntity<PostEntity> updatePost(
			@RequestHeader(value="Authorization") String auth,
			@RequestBody @Valid PostRequest post,
			@RequestParam(value ="id") Long id){
		return service.update(post,id);
	}
	@DeleteMapping
	public ResponseEntity<PostEntity> deletePost(
			@RequestHeader(value="Authorization") String auth,
			@RequestParam("id") Long id){
		return service.delete(id);
	}



}
