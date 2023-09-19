package com.example.comment.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity @Setter
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id @GeneratedValue
    private Long id;
    private String content;
    private UUID targetId;
    private Long memberId;
    private String memberImage;
    private String memberName;

}
