package com.example.easy_notes.note;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Ajouter cette importation
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity  
@Table(name = "notes")  
@EntityListeners(AuditingEntityListener.class)  
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true) 
public class Note {
    
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;  
    
    @NotBlank(message = "La valeur titre ne peut pas être vide")  
    private String title;  
    
    @NotBlank(message = "La valeur content ne peut pas être vide")  
    private String content;  
    
    @Column(nullable = false, updatable = false)  
    @Temporal(TemporalType.DATE)  
    @CreatedDate  
    private Date createdAt;  
    
    @Column(nullable = false)  
    @Temporal(TemporalType.DATE)  
    @LastModifiedDate  
    private Date updatedAt;

   
    public Note() {}  // Constructeur par défaut

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Note(long id, 
                @NotBlank(message = "La valeur titre ne peut pas être vide") String title,
                @NotBlank(message = "La valeur content ne peut pas être vide") String content, 
                Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
