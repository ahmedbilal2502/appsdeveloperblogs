package com.appsdeveloperblogs.app.ws.repository;

import com.appsdeveloperblogs.app.ws.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.email = :email and (t.expired = false or t.revoked = false)\s
      """)

    List<Token> findAllValidTokenByUser(String email);

    Optional<Token> findByToken(String token);
}