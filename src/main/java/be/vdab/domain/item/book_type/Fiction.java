package be.vdab.domain.item.book_type;

import be.vdab.domain.item.Book;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("FICTION")
public class Fiction extends Book {

    private Genre genre;
    private String summary;

    public Fiction () { }

    public Fiction(Long id, String title, double price, String supplierId, String author,
                   String isbn, int pages, Genre genre, String summary) {
        super(id, title, price, supplierId, author, isbn, pages);
        this.genre = genre;
        this.summary = summary;
    }

    public Genre getGenre() {
        return genre;
    }

    @Enumerated(EnumType.ORDINAL)
    public void setGenre(Genre genre) { this.genre = genre;}

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) { this.summary = summary; }

    public enum Genre {
        THRILLER, FANTASY, DETECTIVE, ROMANCE, SCIFI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fiction fiction = (Fiction) o;
        return genre == fiction.genre &&
                summary.equals(fiction.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, summary);
    }
}
