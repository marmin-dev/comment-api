package com.demo.news.dto;


import com.demo.news.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {

    public String author;
    public String title;

    /*request dto에서 바로 엔티티로 전달되는 객체*/
    public Comment toEntity(CommentRequestDto dto){
        return  Comment.builder()
                .author(dto.author)
                .title(dto.title)
                .build();
    }
}
