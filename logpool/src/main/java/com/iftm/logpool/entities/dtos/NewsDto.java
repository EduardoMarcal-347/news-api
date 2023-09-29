package com.iftm.logpool.entities.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class NewsDto implements Serializable {

    private String id;
    private String tittle;
    private String date;
    private String editorName;
    private List posts;

    public NewsDto() {
    }

    public NewsDto(String id, String tittle, String date, String editorName, List posts) {
        this.id = id;
        this.tittle = tittle;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List getPosts() {
        return posts;
    }

    public void setPosts(List posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDto newsDto = (NewsDto) o;
        return Objects.equals(id, newsDto.id) && Objects.equals(tittle, newsDto.tittle) && Objects.equals(date, newsDto.date) && Objects.equals(editorName, newsDto.editorName) && Objects.equals(posts, newsDto.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tittle, date, editorName, posts);
    }

    @Override
    public String toString() {
        return "NewsDto{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", date='" + date + '\'' +
                ", editorName='" + editorName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
