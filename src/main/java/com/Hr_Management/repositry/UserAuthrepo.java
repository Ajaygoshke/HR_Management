package com.Hr_Management.repositry;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hr_Management.model.UserAuth;

@Repository
public interface UserAuthrepo extends JpaRepository<UserAuth,Long> {

	Optional<UserAuth>findByUserEmail(String userEmial);
	Optional<UserAuth> findByUserName(String userName);
}
