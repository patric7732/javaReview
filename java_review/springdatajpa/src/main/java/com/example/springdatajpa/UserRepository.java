package com.example.springdatajpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);
    List<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);

    @Modifying
    @Query("UPDATE User u set u.email= :email where u.id = :id")
    int updateUserEmail(@Param("id") Long id, @Param("email") String email);

    @Modifying
    @Query("DELETE from User u Where u.email = :email")
    int deleteByEmail(@Param("email") String email);


}
