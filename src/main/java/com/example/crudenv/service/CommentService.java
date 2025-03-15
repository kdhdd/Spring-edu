package com.example.crudenv.service;

import com.example.crudenv.dto.CommentDto;
import com.example.crudenv.entity.Comment;
import com.example.crudenv.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentDto commentRegister(CommentDto commentDto) {

        Comment comment = Comment.builder()
                .comment(commentDto.getComment())
                .build();

        comment = commentRepository.save(comment);
        return CommentDto.entityToDto(comment);
    }

    public List<CommentDto> getComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentDto::entityToDto)
                .collect(Collectors.toList());
    }

    public CommentDto getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        return CommentDto.entityToDto(comment);
    }
}
