package com.example.securityadjwt2.dao;


import com.example.securityadjwt2.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dusk
 * @since 2020/6/14 11:30
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
