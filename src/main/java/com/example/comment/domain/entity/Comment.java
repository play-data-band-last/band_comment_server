package com.example.comment.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity @Setter
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments", indexes = @Index(name = "boardId", columnList = "targetId"))

public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private UUID targetId;
    private Long memberId;
    private String memberImage;
    private String memberName;
    @Builder.Default
    private Boolean isValid = Boolean.TRUE;

}
