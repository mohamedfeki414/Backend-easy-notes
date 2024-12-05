package com.example.easy_notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.easy_notes.note.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOrderByCreatedAtDesc();
    List<Note> findByTitleStartingWith(String prefix);
    List<Note> findByTitleAndContent(String t, String c);

    // Méthode corrigée pour compter les notes en fonction du contenu
    @Query("SELECT COUNT(n) FROM Note n WHERE n.content LIKE %:content%")
    int countByContent(@Param("content") String content);
}
