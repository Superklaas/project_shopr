package be.vdab.domain.item.book_type;

import be.vdab.domain.item.Book;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@DiscriminatorValue("FICTION")
public class Fiction extends Book {

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    @Size(max = 255)
    private String summary;

    public Fiction(String title, double price, String supplierId, int inventory, String isbn) {
        super(title, price, supplierId, inventory, isbn);
    }

    public Fiction() {

    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) { this.genre = genre;}

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) { this.summary = summary; }

    public enum Genre {
        THRILLER, FANTASY, DETECTIVE, ROMANCE, SCIFI
    }

}
