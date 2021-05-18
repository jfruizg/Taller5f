package edu.unbosque.JPATutorial.jpa.entities;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "Book") // Optional
@NamedQueries({
        @NamedQuery(name = "Book.findByTitle",
                query = "SELECT b FROM Book b WHERE b.title = :title")
})
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer bookId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(name = "isbn_number")
    private String isbn;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Edition> edition = new ArrayList<>();

    public Book() {}

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Book(Integer bookId, String title, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
    }


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Edition> getEdition() { return edition; }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setEdition(List<Edition> edition) {
        this.edition = edition;
    }

    public void addEdition(Edition edition) {
        this.edition.add(edition);
        edition.setBook(this);
    }

    public void deletEdition(Edition edition){
        this.edition.remove(edition);
    }
    public void modifyEdition(Edition edition){
        this.edition.remove(edition);
        this.edition.add(edition);
        edition.setBook(this);
    }

}
