package com.org.onlinetailoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.onlinetailoring.entity.UserDetails;

/**
 * The Interface UserDetailsRepository.
 */
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

}
