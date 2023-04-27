package com.app.reearth.reearth.Repostiory;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.app.reearth.reearth.Entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findOneByEmailAndPassword(String email, String password);

	User findByEmail(String email);

	boolean existsByEmail(String email);
}
