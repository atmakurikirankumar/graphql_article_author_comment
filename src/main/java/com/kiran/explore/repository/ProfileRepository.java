package com.kiran.explore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.explore.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	Optional<Profile> findById(Long id);

	void deleteById(Long id);
	
}