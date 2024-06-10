package com.interview.notes.model;

public class Note {

	
	private Long id;
	private String title;
	private String body;
	
	private static long idCounter = 0;
	
	public Note() {
		this.id = idCounter++;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
