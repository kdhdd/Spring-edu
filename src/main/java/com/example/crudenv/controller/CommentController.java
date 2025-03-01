package com.example.crudenv.controller;

import com.example.crudenv.dto.CommentDto;
import com.example.crudenv.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/regis")
    public ResponseEntity<CommentDto> commentRegister(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.commentRegister(commentDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<CommentDto>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }
}
