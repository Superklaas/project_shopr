package be.vdab.domain.item.book_type;

import be.vdab.domain.item.Book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("FICTION")
public class Fiction extends Book {

    private Genre genre;
    private String summary;

    public Genre getGenre() {
        return genre;
    }

    public Fiction setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Fiction setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public enum Genre {
        THRILLER, FANTASY, DETECTIVE, ROMANCE, SCIFI;
    }
}
