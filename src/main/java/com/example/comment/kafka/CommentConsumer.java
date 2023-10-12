package com.example.comment.kafka;

import com.example.comment.domain.request.AlbumUpdateRequest;
import com.example.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentConsumer {
    private final CommentService commentService;

    @RetryableTopic
    @KafkaListener(topics = TopicConfig.memberUpdate)
    public void MemberUpdateListen(AlbumUpdateRequest albumUpdateRequest) throws Exception {

        commentService.updateCommentMember(albumUpdateRequest);
    }

    @RetryableTopic
    @KafkaListener(topics = TopicConfig.memberDelete)
    public void memberDeleteListenr(Long userId) throws Exception {
        commentService.userDelteHandler(userId);
    }

    @DltHandler
    public void processDltMessage(String dltMessage) {
        // DLT 토픽에서 메시지를 처리합니다. (예: 로깅 또는 추가 조사)
        System.out.println("DLT에서 메시지 수신: " + dltMessage);

    }


}
