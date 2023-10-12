package com.example.comment.repository;

import com.example.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c " +
            "from Comment c " +
            "where c.targetId = :targetId " +
            "and c.isValid = True")
    List<Comment> findAllByTargetId(UUID targetId);

    @Modifying
    @Query("update Comment b " +
            "set b.memberName = :memberName " +
            "where b.memberId = :memberId")
    void updateBoardMemberName(@Param("memberName") String memberName, @Param("memberId") Long memberId);

    @Modifying
    @Query("update Comment b " +
            "set b.memberImage = :memberImage " +
            "where b.memberId = :memberId")
    void updateBoardMemberImage( @Param("memberImage") String memberImage, @Param("memberId") Long memberId);

    @Modifying
    @Query("update Comment b " +
            "set b.memberImage = :memberImage," +
            "b.memberName = :memberName " +
            "where b.memberId = :memberId")
    void updateBoardMemberImageAndMemberName(@Param("memberName") String memberName, @Param("memberImage") String memberImage, @Param("memberId") Long memberId);

    Optional<Comment> findByMemberId(Long userId);

    @Modifying
    @Query("update Comment c " +
            "set c.isValid = false " +
            "where c.memberId = :memberId")
    void memberDelete(@Param("memberId") Long userId);

}
