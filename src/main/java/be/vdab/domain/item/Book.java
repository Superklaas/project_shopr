package be.vdab.domain.item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "book_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Book extends Item {

    private String author;
    private String isbn;
    private int pages;

    public Book() { }

    public Book(Long id, String title, double price, String supplierId, String author, String isbn, int pages) {
        super(id, title, price, supplierId);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
