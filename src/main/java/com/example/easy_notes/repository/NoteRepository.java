package com.example.easy_notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.easy_notes.note.Note;
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
	
	List<Note>findByOrderByCreatedAtDesc();
	List<Note>findByTitleStartingWith(String prefix);
	List<Note>findByTitleAndContent(String t,String c);
	int countByContentNbt(String content);
	
	}