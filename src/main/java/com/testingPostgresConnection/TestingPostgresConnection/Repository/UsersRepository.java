package com.testingPostgresConnection.TestingPostgresConnection.Repository;

import com.testingPostgresConnection.TestingPostgresConnection.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("select u from Users u where u.userId = ?1")
    Users findByUserId(Integer userId);


}
