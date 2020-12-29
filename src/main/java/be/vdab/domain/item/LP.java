package be.vdab.domain.item;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"artist", "title"})})
@DiscriminatorValue("LP")
public class LP extends Item {

    @Size(max = 100)
    private String artist;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    public LP() { }

    public LP(Long id, String title, double price, String supplierId, int inventory,
              String artist, Genre genre) {
        super(id, title, price, supplierId, inventory);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) { this.artist = artist;}

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) { this.genre = genre;}

    public enum Genre {
        CLASSICAL, POP, ROCK, DANCE, RB, HIPHOP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LP lp = (LP) o;
        return artist.equals(lp.artist) &&
                genre == lp.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, genre);
    }
}
