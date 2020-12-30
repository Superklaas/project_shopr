package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "book_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Book extends Item {

    @Size(max = 100)
    private String author;

    @Column(unique = true)
    @NotBlank
    @Pattern( // isbn can be entered as number sequence or separated by dash/dot/whitespace
            regexp = "^[0-9]{3}[-\\.\\s]?[0-9]{2}[-\\.\\s]?[0-9]{4}[-\\.\\s]?[0-9]{3}[-\\.\\s]?[0-9]$",
            message = "ISBN must be valid")
    private String isbn;

    private int pages;

    @Column(name = "book_type", insertable = false, updatable = false)
    private String book_type;

    public Book(String title, double price, String supplierId, int inventory, String isbn) {
        super(title, price, supplierId, inventory);
        this.isbn = isbn;
    }

    public Book() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
