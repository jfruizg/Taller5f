package edu.unbosque.JPATutorial.servlets.pojos;

import javax.print.attribute.IntegerSyntax;

public class BookPOJO {

    private Integer bnookID;
    private String title;
    private String isbn_number;
    private Integer author_id;
    private String genre;

    public BookPOJO(Integer bnookID, String title, String isbn_number, Integer author_id, String genre) {
        this.bnookID = bnookID;
        this.title = title;
        this.isbn_number = isbn_number;
        this.author_id = author_id;
        this.genre = genre;
    }

    public Integer getBnookID() {
        return bnookID;
    }

    public void setBnookID(Integer bnookID) {
        this.bnookID = bnookID;
    }

    public String getTitle() {
        return title;
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(String isbn_number) {
        this.isbn_number = isbn_number;
    }


}
