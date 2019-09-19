package com.kiran.explore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.explore.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByArticleid(Long articleid);

	void deleteById(Long id);
}