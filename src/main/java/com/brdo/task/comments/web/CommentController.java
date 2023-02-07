package com.brdo.task.comments.web;

import com.brdo.task.comments.domain.Comment;
import com.brdo.task.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String showComments(Model model) {

        List<Comment> comments = commentService.findAll();

        if(comments.isEmpty())
            comments = commentService.uploadAll();

        model.addAttribute("comments", comments);

        return "comments";
    }
}
