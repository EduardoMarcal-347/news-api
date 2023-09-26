package com.iftm.newsletter.entities.dtos;

import com.iftm.newsletter.entities.News;
import com.iftm.newsletter.entities.Post;

import java.util.List;

public class NewsDto {

    private String tittle;
    private String date;
    private String editorName;
    private List<Post> posts;

    public NewsDto() {
    }

    public NewsDto(String tittle, String date, String editorName, List<Post> posts) {
        this.tittle = tittle;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
    }

    public NewsDto(News entity) {
        this.tittle = entity.getTittle();
        this.date = entity.getDate();
        this.editorName = entity.getEditorName();
        this.posts = entity.getPosts();
    }
}
