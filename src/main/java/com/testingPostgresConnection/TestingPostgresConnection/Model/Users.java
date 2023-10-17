package com.testingPostgresConnection.TestingPostgresConnection.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "age")
    private Integer userAge;
    @Column(name = "email")
    private String email;
    @Column(name = "last_visit")
    private Instant lastVisit;
    @OneToMany(mappedBy = "poster")
    @JsonIgnoreProperties("poster")
    private List<Blog> blogList;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    public List<Comment> commentMade;

}
