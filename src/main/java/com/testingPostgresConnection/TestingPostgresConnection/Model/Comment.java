package com.testingPostgresConnection.TestingPostgresConnection.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("commentMade")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnoreProperties("comment")
    private Blog blog;
    @Column(name = "content")
    private String content;
    @Column(name = "create_date", insertable = false, updatable = false)
    private Instant createDate;
}
