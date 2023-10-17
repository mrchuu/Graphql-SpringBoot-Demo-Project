package com.testingPostgresConnection.TestingPostgresConnection.Repository;

import com.testingPostgresConnection.TestingPostgresConnection.Model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;
import java.sql.Connection;

@GraphQlRepository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT b.* FROM Blog b " +
            "LEFT JOIN Comment c " +
            "on (:sortType IS NOT NULL AND b.blog_id = c.blog_id) " +
            "AND (:sortType IS NULL " +
            "OR (:sortType = 'mostPopularInDay' AND c.create_date >= current_timestamp  - Interval '24 hours') " +
            "OR (:sortType = 'mostPopularInWeek' AND DATE_TRUNC('WEEK', c.create_date) = DATE_TRUNC('WEEK', CURRENT_DATE))) " +
            "Where (:searchValue is Null or b.title like %:searchValue%) " +
            "GROUP BY c.blog_id, b.blog_id, b.content, b.post_date, b.user_id, b.title " +
            "order By " +
            "Case " +
            "WHEN :sortType = 'mostPopularInDay' THEN count(c.comment_id) END DESC, " +
            "Case " +
            "WHEN :sortType = 'mostPopularInWeek' THEN count(c.comment_id) END DESC, " +
            "Case " +
            "WHEN :sortType = 'latest' THEN b.post_date END DESC, " +
            "Case " +
            "When :sortType = 'oldest' THEN b.post_date END ASC ", nativeQuery = true)
    public Page<Blog> getBlogPaginated(Pageable pageable,@Param("sortType") String sortType,@Param("searchValue") String searchValue);

}
