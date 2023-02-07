package com.brdo.task.comments.service.impl;

import com.brdo.task.comments.domain.Comment;
import com.brdo.task.comments.repository.CommentRepository;
import com.brdo.task.comments.service.CommentService;
import com.brdo.task.comments.service.dto.CommentsListDTO;
import com.brdo.task.comments.service.mapper.CommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    @Value("${request.url}")
    private String requestUrl;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> result = commentRepository.findAll();
        if (result.isEmpty())
            log.warn("IN getAll - no comments found");

        log.info("IN getAll - {} comments found", result.size());
        return result;
    }

    @Override
    public List<Comment> uploadAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(requestUrl)
                .queryParam("limit","0").build();
        ResponseEntity<CommentsListDTO> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                CommentsListDTO.class);

        CommentsListDTO commentsListDTO = response.getBody();
        List<Comment> comments = commentMapper.commentListDTOsToComments(commentsListDTO);

        return commentRepository.saveAll(comments);
    }
}
