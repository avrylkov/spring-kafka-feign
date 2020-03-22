package com.example.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "QUEUE")
public class Queue {

    private long id;
    private String text;
    private Boolean active;
    private String responseText;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TEXT", nullable = true, length = 50)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "ACTIVE", nullable = true, precision = 0)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "RESPONSE_TEXT")
    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return id == queue.id &&
                Objects.equals(text, queue.text) &&
                Objects.equals(active, queue.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, active);
    }

    @Override
    public String toString() {
        return getId() + ", text=" + getText();
    }
}
