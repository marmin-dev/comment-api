package com.demo.news.controller;

import com.demo.news.dto.CommentRequestDto;
import com.demo.news.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class NewsController {

    private final CommentService commentService;

    /*POST 댓글
    param: RequestDto =>return: id
     */
    @PostMapping
    public ResponseEntity<?> commentSave(@RequestBody CommentRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.createComment(dto));
    }

    /*GET 리스트*/
    @GetMapping
    public ResponseEntity<?> commentGet(){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.joinComment());
    }
}
