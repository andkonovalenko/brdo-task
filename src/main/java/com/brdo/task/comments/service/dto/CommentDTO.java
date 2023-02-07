package com.brdo.task.comments.service.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "body",
        "postId",
        "user"
})
public class CommentDTO implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("body")
    private String body;
    @JsonProperty("postId")
    private Long postId;
    @JsonProperty("user")
    private UserDTO user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("postId")
    public Long getPostId() {
        return postId;
    }

    @JsonProperty("postId")
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @JsonProperty("user")
    public UserDTO getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(UserDTO user) {
        this.user = user;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
