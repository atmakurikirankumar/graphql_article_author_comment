package com.kiran.explore.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.kiran.explore.models.Article;
import com.kiran.explore.models.Comment;
import com.kiran.explore.models.Profile;
import com.kiran.explore.repository.ArticleRepository;
import com.kiran.explore.repository.CommentRepository;
import com.kiran.explore.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
	private ArticleRepository articleRepository;
	private CommentRepository commentRepository;
	private ProfileRepository profileRepository;

	public List<Article> getArticles() {
		return articleRepository.findAll();
	}

	public List<Comment> getComments() {
		return commentRepository.findAll();
	}

	public List<Profile> getProfiles() {
		return profileRepository.findAll();
	}

	public Article getArticle(Long id) {
		Optional<Article> optional = articleRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}