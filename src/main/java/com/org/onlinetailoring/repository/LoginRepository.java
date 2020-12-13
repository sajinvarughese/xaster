package com.org.onlinetailoring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.onlinetailoring.entity.Login;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginRepository.
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	/**
	 * Find by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the login
	 */
	Login findByUsernameAndPassword(String username, String password);

	/**
	 * Find by role.
	 *
	 * @param role the role
	 * @return the list
	 */
	List<Login> findByRole(String role);

	Login findByUsername(String username);

}
