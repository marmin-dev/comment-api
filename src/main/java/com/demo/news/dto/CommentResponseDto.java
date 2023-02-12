package com.demo.news.dto;

import com.demo.news.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {

    public String author;

    public String title;

    public LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment){
        this.author = comment.getAuthor();
        this.title = comment.getTitle();
        this.modifiedAt = comment.getModifiedAt();
    }
}
