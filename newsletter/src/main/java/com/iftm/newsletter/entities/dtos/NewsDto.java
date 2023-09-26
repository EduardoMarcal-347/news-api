package com.iftm.newsletter.entities.dtos;

import com.iftm.newsletter.entities.News;
import com.iftm.newsletter.entities.Post;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class NewsDto {

    private String id;
    private String tittle;
    private String date;
    private String editorName;
    private List<Post> posts;

    public NewsDto() {
    }

    public NewsDto(String id, String tittle, String date, String editorName, List<Post> posts) {
        this.tittle = tittle;
        this.date = date;
        this.editorName = editorName;
        this.posts = posts;
    }

    public NewsDto(News entity) {
        if(entity.getId() != null) this.id = entity.getId().toString();
        this.tittle = entity.getTittle();
        this.date = entity.getDate().toString();
        this.editorName = entity.getEditorName();
        this.posts = entity.getPosts();
    }

    public News toNews(){
        ObjectId id = null;
        if(this.id != null) id = new ObjectId(this.id);
        return new News(
                id,
                this.tittle,
                LocalDate.parse(this.date),
                this.editorName,
                this.posts
        );
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
