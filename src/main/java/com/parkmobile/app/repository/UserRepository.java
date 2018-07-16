package com.parkmobile.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parkmobile.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(final String email)
	public User findByPassword(final String password);
}
