package com.iftm.newsletter.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "news")
public class News {

    @Id
    private ObjectId id;
    private String tittle;
    private String date;
    private String editorName;
    private List<Post> posts;

    public News() {
    }

    public News(ObjectId id, String tittle, String date, String editorName, List<Post> posts) {
        this.id = id;
        this.tittle = tittle;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", date='" + date + '\'' +
                ", editorName='" + editorName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
