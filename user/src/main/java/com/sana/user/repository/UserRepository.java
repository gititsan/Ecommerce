package com.sana.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sana.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
