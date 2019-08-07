package com.restful.jsonserver.data;

public class ComplexPost {
	
	String id;
	String title;
	String author;
	Info info;

	public ComplexPost(String id, String title, String author, Info info) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.info = info;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Info getInfo() {
		return this.info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
	}

}