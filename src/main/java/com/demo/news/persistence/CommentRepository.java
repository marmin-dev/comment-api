package com.demo.news.persistence;

import com.demo.news.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,String> {
    @Query(value = "SELECT * FROM comment ORDER BY id DESC", nativeQuery = true)
    public List<Comment> findAllByDesc();
}
