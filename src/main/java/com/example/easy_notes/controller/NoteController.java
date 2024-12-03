package com.example.easy_notes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easy_notes.note.Note;
import com.example.easy_notes.repository.NoteRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/notes")
@Tag(name="Note", description="the product API")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id);
    }

    @PostMapping
    public void createNote(@RequestBody Note note) {
        noteRepository.save(note);
    }

    @PutMapping("/{id}")
    public void updateNote(@RequestBody Note note) {
    	noteRepository.save(note); 
        }
  

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
    @GetMapping("/orderBY/date")
    public List<Note>findByOrderByCreatedAtDesc(){
    	return noteRepository.findByOrderByCreatedAtDesc();
    }
    @GetMapping("/starting/{prefixe}")
    public List<Note>findByTitleStartingWith(@PathVariable String prefixe){
    	return noteRepository.findByTitleStartingWith(prefixe);
    }
}

