package be.vdab.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LP")
public class LP extends Item {

    private String artist;
    private Genre genre;

    public LP() { }

    public String getArtist() {
        return artist;
    }

    public LP setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public LP setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public enum Genre {
        CLASSICAL, POP, ROCK, DANCE, RB, HIPHOP;
    }
}
