package com.example.books;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    // Sets id as primary key, auto generates ID and increments by one each time new book is added
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String imageUrl;
    private String name;
    private String author;
    private String description;
    private String rating;

    public Book(){};

    public Book(String imageUrl, String name, String author, String description, String rating) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.author = author;
        this.description = description;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }
}
