package com.caidonglun.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caidonglun.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{


}
