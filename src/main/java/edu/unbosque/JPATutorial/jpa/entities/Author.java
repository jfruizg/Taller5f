package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author") // Optional
@NamedQueries({
        @NamedQuery(name = "Author.findByName",
                query = "SELECT a FROM Author a WHERE a.name = :name")
})
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private Integer authorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Author() {}

    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Author(Integer authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void deletBook(Book book){
        books.remove(book);
    }
    public void modifyBook(Book book){
        books.remove(book);
        books.add(book);
        book.setAuthor(this);
    }

}
