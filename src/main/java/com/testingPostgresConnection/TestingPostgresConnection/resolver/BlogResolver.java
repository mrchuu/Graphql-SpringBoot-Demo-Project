package com.testingPostgresConnection.TestingPostgresConnection.resolver;

import com.testingPostgresConnection.TestingPostgresConnection.Model.Blog;
import com.testingPostgresConnection.TestingPostgresConnection.Model.input.BlogDisplayInput;
import com.testingPostgresConnection.TestingPostgresConnection.Model.pageResponse.BlogPageResponse;
import com.testingPostgresConnection.TestingPostgresConnection.Model.pageResponse.PageInfo;
import com.testingPostgresConnection.TestingPostgresConnection.Repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class BlogResolver {
    private final BlogRepository blogRepository;

    @QueryMapping
    public BlogPageResponse getBlogsPaginated(@Argument("input") BlogDisplayInput blogDisplayInput) {
        Pageable pageable = PageRequest.of(blogDisplayInput.getIndex(), blogDisplayInput.getSize());
        Page<Blog> blogPage = blogRepository.getBlogPaginated(pageable, blogDisplayInput.getSortType(), blogDisplayInput.getSearchValue());
        return new BlogPageResponse(
                blogPage.getContent().toArray(new Blog[0]),
                new PageInfo(
                        blogPage.getPageable().getPageNumber(),
                        blogPage.getPageable().getPageSize(),
                        blogPage.isLast(),
                        blogPage.isFirst(),
                        blogPage.getTotalPages(),
                        blogPage.getTotalElements()
                )
        );
    }
}
