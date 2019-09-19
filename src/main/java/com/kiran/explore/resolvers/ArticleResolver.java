package com.kiran.explore.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.kiran.explore.models.Article;
import com.kiran.explore.models.Comment;
import com.kiran.explore.models.Profile;
import com.kiran.explore.repository.CommentRepository;
import com.kiran.explore.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ArticleResolver implements GraphQLResolver<Article> {
	private CommentRepository commentRepository;
	private ProfileRepository profileRepository;

	public Profile getAuthor(Article article) {

		Optional<Profile> optional = profileRepository.findById(article.getAuthorid());
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Comment> getComments(Article article) {
		return commentRepository.findByArticleid(article.getId());
	}
}