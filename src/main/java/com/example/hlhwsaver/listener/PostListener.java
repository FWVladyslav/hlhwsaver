package com.example.hlhwsaver.listener;

import com.example.hlhwsaver.domain.Post;
import com.example.hlhwsaver.dto.QueuePostCreate;
import com.example.hlhwsaver.repo.PostRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
@EnableSqs
public class PostListener {
    private final PostRepository postRepository;
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    @SqsListener(
            value = "${queue-url}",
            deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    //10 max by default
    public void consumeNewFileRequest( final String input) {
        try {
            log.info("LIVE MESSAGE: " + input);
            var queuePost = objectMapper.readValue(input, QueuePostCreate.class);
            var toSave = new Post(queuePost.getUserId(),queuePost.getContent());
            postRepository.save(toSave);
        }
        catch (Exception e){
            log.error("error: " + e.getMessage());
        }
    }
}
