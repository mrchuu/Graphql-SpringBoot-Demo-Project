package com.testingPostgresConnection.TestingPostgresConnection.resolver;
import com.testingPostgresConnection.TestingPostgresConnection.Model.Users;
import com.testingPostgresConnection.TestingPostgresConnection.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class UsersResolver {
    private final UsersRepository usersRepository;
    @QueryMapping
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    @MutationMapping
    public Users findUserById(@Argument("userId") Integer userId){
        return usersRepository.findByUserId(userId);
    }
}
