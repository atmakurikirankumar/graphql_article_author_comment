package com.kiran.explore.input.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArticleInput {
	private Long id;
	private String title;
	private String text;
}