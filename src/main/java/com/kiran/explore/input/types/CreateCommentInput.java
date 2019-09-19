package com.kiran.explore.input.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentInput {
	private String text;
	private Long authorid;
	private Long articleid;
}