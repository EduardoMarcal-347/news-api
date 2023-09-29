package com.iftm.logpool.entities.dtos;

import com.iftm.logpool.entities.Log;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class LogDto<T> implements Serializable {

    private String id;
    private String action;
    private Date date = new Date();
    private T object;
    private String objectType;

    public LogDto() {
    }

    public LogDto(T object, String objectType) {
        this.object = object;
        this.objectType = objectType;
    }

    public LogDto(Log<T> entity) {
        this.id = entity.getId();
        this.action = entity.getAction();
        this.date = entity.getDate();
        this.object = entity.getObject();
        this.objectType = entity.getObjectType();
    }

    public Log<T> toLog() {
        var log = new Log<T>();

        if(this.id != null && !this.id.isBlank())
            log.setId(this.id);
        log.setAction(this.action);
        log.setDate(this.date);
        log.setObject(this.object);
        if(this.objectType != null && !this.objectType.isBlank())
            log.setObjectType(this.objectType);
        return log;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogDto<?> logDto = (LogDto<?>) o;
        return Objects.equals(id, logDto.id) && Objects.equals(action, logDto.action) && Objects.equals(date, logDto.date) && Objects.equals(object, logDto.object) && Objects.equals(objectType, logDto.objectType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, date, object, objectType);
    }

    @Override
    public String toString() {
        return "LogDto{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", date=" + date +
                ", object=" + object +
                ", objectType='" + objectType + '\'' +
                '}';
    }
}
