package com.example.comment.service;


import com.example.comment.domain.entity.Comment;
import com.example.comment.domain.request.CommentRequest;
import com.example.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentRequest request) {
        Comment comment = Comment.builder()
                .content(request.getContent())
                .memberName(request.getMemberName())
                .memberImage(request.getMemberImage())
                .targetId(request.getTargetId())
                .memberId(request.getMemberId())
                .build();
        commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> findAllByTargetId(UUID targetId) {
        return commentRepository.findAllByTargetId(targetId);
    }

    @Transactional
    public void updateComment(Long commentId, CommentRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setContent(request.getContent());
    }

}
