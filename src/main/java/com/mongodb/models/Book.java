package com.mongodb.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document(collection = "book")
public class Book {

	@Id
	private String bookId;

	@TextIndexed(weight = 5)
	@Field(value = "title")
	private String title;

	private Date publishDate;

	private int pageCount;

	private BigDecimal price;

	private Author author;

	private List<String> tags = new ArrayList<String>();

	private Library location;

	@TextIndexed(weight = 1)
	private String description;

	@TextScore
	private Float score;

	public Book() {

	}

	public Book(String title, Date publishDate, int pageCount, BigDecimal price) {
		this.title = title;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Library getLocation() {
		return location;
	}

	public void setLocation(Library location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate + ", pageCount="
				+ pageCount + ", price=" + price + ", author=" + author + ", tags=" + tags + ", location=" + location
				+ ", description=" + description + ", score=" + score + "]";
	}

}
