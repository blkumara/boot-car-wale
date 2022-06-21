package com.ty.bootcarwaleapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

	List<User> findByPhone(long phone);

	@Query("SELECT u FROM User u WHERE u.gender=?1 AND u.role=?2")
	List<User> getData(String gender, String role);

	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	List<User> validateUser(@Param("email") String email, @Param("password") String password);

}
