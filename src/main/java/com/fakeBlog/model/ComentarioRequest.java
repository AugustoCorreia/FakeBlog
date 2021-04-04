package com.fakeBlog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioRequest {

	@NotNull
	private Long post_id;
	@NotNull
	private String texto;
	@NotNull
	private Long user_id;

}
