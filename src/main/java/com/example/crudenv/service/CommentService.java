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

    @Transactional
    public CommentDto updateComment(Long commentId, CommentDto updateCommentDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("해당 댓글이 존재하지 않습니다."));

        comment.updateComment(updateCommentDto.getComment());
        commentRepository.save(comment);

        return CommentDto.entityToDto(comment);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("해당 댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
    }
}
