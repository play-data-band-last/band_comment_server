package com.example.comment.kafka;

import com.example.comment.domain.request.AlbumUpdateRequest;
import com.example.comment.kafka.dto.KafkaListnerDto;
import com.example.comment.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class CommentConsumer {
    private final CommentService commentService;
    private final ObjectMapper objectMapper;

    @RetryableTopic
    @KafkaListener(topics = TopicConfig.memberUpdate)
    public void MemberUpdateListen(KafkaListnerDto kafkaListnerDto) throws Exception {

        commentService.updateCommentMember(kafkaListnerDto);
    }

    @RetryableTopic
    @KafkaListener(topics = TopicConfig.memberDelete)
    public void memberDeleteListenr(KafkaListnerDto kafkaListnerDto) throws Exception {
//        throw new Exception();
        commentService.userDelteHandler(kafkaListnerDto.getMemberId());
    }

    @DltHandler
    void handler(Message<?> msg,
                 ConsumerRecord<String,byte[]> record) {
        System.out.println(msg);
    }


}
