package com.appsdeveloperblogs.app.ws.repository;

import com.appsdeveloperblogs.app.ws.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
