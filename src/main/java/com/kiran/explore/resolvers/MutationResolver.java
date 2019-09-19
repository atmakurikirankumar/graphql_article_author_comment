package com.kiran.explore.resolvers;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.kiran.explore.input.types.CreateArticleInput;
import com.kiran.explore.input.types.CreateCommentInput;
import com.kiran.explore.input.types.CreateProfileInput;
import com.kiran.explore.input.types.UpdateArticleInput;
import com.kiran.explore.input.types.UpdateProfileInput;
import com.kiran.explore.models.Article;
import com.kiran.explore.models.Comment;
import com.kiran.explore.models.Profile;
import com.kiran.explore.repository.ArticleRepository;
import com.kiran.explore.repository.CommentRepository;
import com.kiran.explore.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {
	private ArticleRepository articleRepository;
	private CommentRepository commentRepository;
	private ProfileRepository profileRepository;

	@Transactional
	public Article createArticle(CreateArticleInput input) {
		return articleRepository
				.saveAndFlush(new Article(null, input.getTitle(), input.getText(), input.getAuthorid()));
	}

	@Transactional
	public Article updateArticle(UpdateArticleInput input) {
		Article article = articleRepository.findById(input.getId())
				.orElseThrow(() -> new RuntimeException("Article Not Found"));
		article.setText(input.getText());
		article.setTitle(input.getTitle());
		return article;
	}

	@Transactional
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);
	}

	@Transactional
	public Profile createProfile(CreateProfileInput input) {
		return profileRepository.saveAndFlush(new Profile(null, input.getUsername(), input.getBio()));
	}

	@Transactional
	public Profile updateProfile(UpdateProfileInput input) {
		Profile profile = profileRepository.findById(input.getId())
				.orElseThrow(() -> new RuntimeException("Profile Not Found"));
		profile.setBio(input.getBio());
		return profile;
	}

	@Transactional
	public void deleteProfile(Long id) {
		profileRepository.deleteById(id);
	}

	@Transactional
	public Comment createComment(CreateCommentInput input) {
		return commentRepository
				.saveAndFlush(new Comment(null, input.getText(), input.getArticleid(), input.getAuthorid()));
	}

	@Transactional
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}
}