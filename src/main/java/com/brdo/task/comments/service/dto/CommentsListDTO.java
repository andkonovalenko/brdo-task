package com.brdo.task.comments.service.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "comments",
        "total",
        "skip",
        "limit"
})
public class CommentsListDTO implements Serializable {

    @JsonProperty("comments")
    private List<CommentDTO> comments;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("skip")
    private Integer skip;
    @JsonProperty("limit")
    private Integer limit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("comments")
    public List<CommentDTO> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("skip")
    public Integer getSkip() {
        return skip;
    }

    @JsonProperty("skip")
    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
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

