package com.testingPostgresConnection.TestingPostgresConnection.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    @Column(name = "content")
    private String content;
    @Column(name = "post_date", insertable = false, updatable = false)
    private Instant postDate;
    @ManyToOne
    @JsonIgnoreProperties("blogList")
    @JoinColumn(name = "user_id")
    private Users poster;
    @OneToMany(mappedBy = "blog")
    @JsonIgnoreProperties("blog")
    private List<Comment> comment;
    @Column(name = "title")
    private String title;
}
