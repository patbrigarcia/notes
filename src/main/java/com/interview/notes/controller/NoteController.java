package com.interview.notes.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.interview.notes.model.Note;

@RestController
@RequestMapping("/notes")
public class NoteController {
	private List<Note> notes = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<Note> create(@RequestBody Note note) {
		
		if(note.getBody().trim() == null || note.getTitle().trim() == null){
			return new ResponseEntity<>(note, HttpStatus.NOT_ACCEPTABLE);
		}else {
			Long id = (long)notes.size() + 1;
			note.setId(id);
			notes.add(note);
			return new ResponseEntity<>(note, HttpStatus.CREATED);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Note>> getAllNotes() {
		return new ResponseEntity<>(notes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
		Note note = findNoteById(id);
		if(note != null) {
			return new ResponseEntity<>(note, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
		Note note = findNoteById(id);
		if(note != null) {
			if(note.getBody().trim() == null || note.getTitle().trim() == null){
				return new ResponseEntity<>(note, HttpStatus.NOT_ACCEPTABLE);
			}else {
				note.setTitle(updatedNote.getTitle());
				note.setBody(updatedNote.getBody());
				return new ResponseEntity<>(note, HttpStatus.OK);
			}	
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Note> daleteNote(@PathVariable Long id) {
		Note note = findNoteById(id);
		if(note != null) {
			notes.remove(note);
			return new ResponseEntity<>(HttpStatus.OK); 
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	private Note findNoteById(Long id) {
		return notes.stream()
				.filter(note -> note.getId().equals(id))
				.findFirst()
				.orElse(null);
	}
	
}
