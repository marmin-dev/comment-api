package com.demo.news.service;

import com.demo.news.dto.CommentRequestDto;
import com.demo.news.dto.CommentResponseDto;
import com.demo.news.entity.Comment;
import com.demo.news.persistence.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    /*댓글 저장 기능 => id 값 반환*/
    public Long createComment(CommentRequestDto requestDto){
        Comment newComment = requestDto.toEntity(requestDto);
        commentRepository.save(newComment);
        return newComment.id;
    }

    /*댓글 조회 기능 => ResponseDto*/
    public List<CommentResponseDto> joinComment(){
        List<CommentResponseDto> dtoList = new ArrayList<>();
        dtoList = commentRepository.findAllByDesc().stream().map(comment -> new CommentResponseDto(comment
        )).collect(Collectors.toList());
        return dtoList;
    }


}
