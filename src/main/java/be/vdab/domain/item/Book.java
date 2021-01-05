package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//TRAINER TODO: als je uniqueConstraints wil gebruiken op title en ook de title column hebben in Book table kan je AttributeOverride gebruiken om deze van de parent te overiden
@AttributeOverride(column = @Column(name = "title", length = 100, nullable = false), name = "bookTitle")
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

    @Size(max = 100)
    @NotNull(message = "Title of book must not be null")
    private String bookTitle;

    @Column(name = "book_type", insertable = false, updatable = false)
    private String bookType;

    public Book(String bookTitle, double price, String supplierId, int inventory, String isbn) {
        super(bookTitle, price, supplierId, inventory);
        this.isbn = isbn;
    }

    public Book() {}

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String title) {
        this.bookTitle = title;
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
