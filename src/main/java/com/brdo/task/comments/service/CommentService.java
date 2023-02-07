package com.brdo.task.comments.service;

import com.brdo.task.comments.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    List<Comment> uploadAll();
}
