package com.brdo.task.comments.service.mapper;

import com.brdo.task.comments.domain.Comment;
import com.brdo.task.comments.service.dto.CommentDTO;
import com.brdo.task.comments.service.dto.CommentsListDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentMapper {

    private static final String DATE_FORMAT = "d-m-Y H:m:s";

    public List<Comment> commentListDTOsToComments(CommentsListDTO commentsListDTO) {
        return commentsListDTO.getComments().stream().filter(Objects::nonNull).map(this::commentDTOToComment).collect(Collectors.toList());
    }

    public Comment commentDTOToComment(CommentDTO commentDTO) {
        if (commentDTO == null) {
            return null;
        } else {
            Comment comment = new Comment();
            comment.setPostId(commentDTO.getPostId());
            comment.setBody(commentDTO.getBody());
            comment.setUserName(StringUtils.capitalize(commentDTO.getUser().getUsername()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
                    .withZone(ZoneId.systemDefault());
            String formattedDate = formatter.format(Instant.now());
            comment.setUpdatedAt(formattedDate);
            return comment;
        }
    }
}
