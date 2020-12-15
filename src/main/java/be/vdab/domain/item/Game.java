package be.vdab.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("GAME")
public class Game extends Item {

    private String publisher;
    private int minimumAge;
    private Genre genre;

    public String getPublisher() {
        return publisher;
    }

    public Game setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public Game setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Game setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public enum Genre {
        MMORPG, RPG, FPS, RTS, RACE;
    }
}
