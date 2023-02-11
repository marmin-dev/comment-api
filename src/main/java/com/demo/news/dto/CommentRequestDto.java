package com.demo.news.dto;


import com.demo.news.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {

    String author
    public String title;

    public Date modifiedDate;

    public Comment toEntity(){
        Comment comment = Comment.builder()
                .author(this.author)
                .title(this.title)
                .modifiedDate(this.modifiedDate)
                .build();


    }
}
