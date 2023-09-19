package com.example.comment.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private String content;
    private UUID targetId;
    private Long memberId;
    private String memberImage;
    private String memberName;
}
