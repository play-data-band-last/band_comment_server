package com.example.comment.repository;

import com.example.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long> {



    List<Comment> findAllByTargetId(UUID targetId);

}
