package org.sm.lab.mybooks.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.sm.lab.mybooks.enums.Genre;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName="book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 2)
    private String title;

    private String author;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date startReadingDate;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date endReadingDate;

    private Long rating;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String review;

    @ManyToOne
    private Reader reader;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private List<Note> notes = new ArrayList<Note>();

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getStartReadingDate() {
		return startReadingDate;
	}

	public void setStartReadingDate(Date startReadingDate) {
		this.startReadingDate = startReadingDate;
	}

	public Date getEndReadingDate() {
		return endReadingDate;
	}

	public void setEndReadingDate(Date endReadingDate) {
		this.endReadingDate = endReadingDate;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public void copyFields(Book fromBook) {
		this.id = fromBook.getId();
		this.title = fromBook.getTitle();
		this.author = fromBook.getAuthor();
		this.startReadingDate = fromBook.getStartReadingDate();
		this.endReadingDate = fromBook.getEndReadingDate();
		this.rating = fromBook.getRating();
		this.genre = fromBook.getGenre();
		this.review = fromBook.getReview();
	}
    
	
}