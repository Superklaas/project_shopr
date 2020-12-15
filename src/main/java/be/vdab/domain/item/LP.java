package be.vdab.domain.item;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("LP")
public class LP extends Item {

    private String artist;
    private Genre genre;

    public LP() { }

    public LP(Long id, String title, double price, String supplierId, String artist, Genre genre) {
        super(id, title, price, supplierId);
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

    @Enumerated(EnumType.ORDINAL)
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
