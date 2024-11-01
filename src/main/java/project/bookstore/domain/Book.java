package project.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private Integer isbn;
    private Double price;

    @ManyToOne // koska ownertable, kirjalla vain 1 kategoria tässä tapauksessa 
    @JsonIgnoreProperties ("books")  // estää ikuisen hakuloopin, keskeytys kun kerran haettu kirja ja liittyvät tiedot
    @JoinColumn(name = "categoryid") // lisää tauluun ja linkkaa yhteen, foreing key nimi
    private Category category; // columnin tyyppi Category koska on linkki kategoria-olioon
    
    public Book() {
    }
    
    public Book(String title, String author, Integer publicationYear, Integer isbn, Double price, Category category) {
        super(); // konstruktoi uuden olion, mitä eroa kun ennen ei ole käytetty?
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
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
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Integer getPublicationYear() {
        return publicationYear;
    }
    
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    public Integer getIsbn() {
        return isbn;
    }
    
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
    
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", isbn=" + isbn + ", price=" + price + ", category=" + category + "]";
    }
    
}
