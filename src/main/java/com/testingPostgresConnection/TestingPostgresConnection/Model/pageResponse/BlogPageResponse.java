package com.testingPostgresConnection.TestingPostgresConnection.Model.pageResponse;

import com.testingPostgresConnection.TestingPostgresConnection.Model.Blog;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BlogPageResponse {
    private Blog[] data;
    private PageInfo pageInfo;
}
