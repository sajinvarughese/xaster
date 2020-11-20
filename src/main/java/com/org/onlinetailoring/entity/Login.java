package com.org.onlinetailoring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
@Entity
public class Login {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	/** The username. */
	String username;
	
	/** The password. */
	String password;
	
	/** The role. */
	String role;
	
	/** The user details. */
	@OneToOne
	@JoinColumn(name="user_id")
	UserDetails userDetails;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the user details.
	 *
	 * @return the user details
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details.
	 *
	 * @param userDetails the new user details
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	} 
	
	
}
