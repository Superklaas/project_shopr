package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Book extends Item {

    private String author;
    @NotBlank
    @Pattern(
            regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$",
            message = "ISBN must be valid")
    private String isbn;
    private int pages;
    private String book_type;

    public Book() { }

    public Book(Long id, String title, double price, String supplierId,
                int inventory, String author,String isbn, int pages) {
        super(id, title, price, supplierId, inventory);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
