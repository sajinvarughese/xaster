package com.org.onlinetailoring.service;

import java.util.List;

import com.org.onlinetailoring.entity.Login;
import com.org.onlinetailoring.entity.UserDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Gets the user details.
	 *
	 * @param username the username
	 * @return the user details
	 */
	public UserDetails getUserDetails(String username);

	/**
	 * Register user.
	 *
	 * @param login the login
	 * @return the user details
	 * @throws Exception the exception
	 */
	public UserDetails registerUser(Login login) throws Exception;

	/**
	 * Gets the user details.
	 *
	 * @param login the login
	 * @return the user details
	 */
	public Login getUserDetails(Login login);

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<UserDetails> getAllUsers();
	
}
