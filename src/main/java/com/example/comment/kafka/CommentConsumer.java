package com.example.comment.kafka;

import com.example.comment.domain.request.UserUpdateRequest;
import com.example.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentConsumer {
    public final CommentService commentService;

    @KafkaListener(topics = TopicConfig.commentUpdate)
    public void listen(UserUpdateRequest userUpdateRequest) throws Exception{
        commentService.updateCommentMember(userUpdateRequest);
    }


}
