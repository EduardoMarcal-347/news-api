package com.iftm.newsletter.entities;

import java.util.List;
import java.util.Objects;

public class Post {

    private String tittle;
    private String authorName;
    private String body;
    private List<Tag> tags;

    public Post() {
    }

    public Post(String tittle, String authorName, String body, List<Tag> tags) {
        this.tittle = tittle;
        this.authorName = authorName;
        this.body = body;
        this.tags = tags;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(tittle, post.tittle) && Objects.equals(authorName, post.authorName) && Objects.equals(body, post.body) && Objects.equals(tags, post.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, authorName, body, tags);
    }

    @Override
    public String toString() {
        return "Post{" +
                "tittle='" + tittle + '\'' +
                ", authorName='" + authorName + '\'' +
                ", body='" + body + '\'' +
                ", tags=" + tags +
                '}';
    }
}
