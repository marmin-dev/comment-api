package com.demo.news.service;

import com.demo.news.dto.CommentRequestDto;
import com.demo.news.persistence.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    public String createComment(CommentRequestDto requestDto){
        return;
    }


}
