package com.example.comment.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KafkaListnerDto {
    private String memberName;
    private String memberImage;
    private Long memberId;

}
