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

    /*댓글 저장 로직 => id 값 반환*/
    public Long createComment(CommentRequestDto requestDto){
        Comment newComment = requestDto.toEntity(requestDto);
        commentRepository.save(newComment);
        return newComment.id;
    }

    /*댓글 조회 로직 => ResponseDto*/
    public List<CommentResponseDto> joinComment(){
        List<CommentResponseDto> dtoList = new ArrayList<>();
        dtoList = commentRepository.findAllByDesc().stream().map(comment -> new CommentResponseDto(comment
        )).collect(Collectors.toList());
        return dtoList;
    }

    /*댓글 수정 로직*/
    public Long updateComment(Long id,String title){
        Comment comment = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("헤당아이디없음"));
        comment.update(title);
        return id;
    }

    /*댓글 삭제 로직*/
    public Long deleteComment(Long id){
        commentRepository.deleteById(id);
        return id;
    }


}
