package com.example.comment.repository;

import com.example.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTargetId(UUID targetId);
    @Modifying
    @Query("update Comment c " +
            "set c.memberName = :memberName, " +
            "c.memberImage = :memberImage " +
            "where c.memberId = :memberId")
    void updateCommentMemberImageAndMemberName(@Param("memberName") String memberName, @Param("memberImage") String memberImage, @Param("memberId") Long memberId);

    @Modifying
    @Query("update Comment c " +
            "set c.memberImage = :memberImage " +
            "where c.memberId = :memberId")
    void updateCommentMemberImage(@Param("memberImage") String memberImage, @Param("memberId") Long memberId);
    @Modifying
    @Query("update Comment c " +
            "set c.memberName = :memberName " +
            "where c.memberId = :memberId")
    void updateCommentMemberName(@Param("memberName") String memberName, @Param("memberId") Long memberId);
}
