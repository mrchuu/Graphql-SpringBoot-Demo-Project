package com.testingPostgresConnection.TestingPostgresConnection.Model.input;

import com.testingPostgresConnection.TestingPostgresConnection.Model.Blog;
import com.testingPostgresConnection.TestingPostgresConnection.Model.Users;
import com.testingPostgresConnection.TestingPostgresConnection.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class BlogInput {
    private String content;
    private Integer poster;

}
