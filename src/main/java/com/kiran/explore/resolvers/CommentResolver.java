package com.kiran.explore.resolvers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.kiran.explore.models.Comment;
import com.kiran.explore.models.Profile;
import com.kiran.explore.repository.ProfileRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {
	private ProfileRepository profileRepository;

	public Profile getAuthor(Comment comment) {
		Optional<Profile> optional = profileRepository.findById(comment.getAuthorid());
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}