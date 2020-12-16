package be.vdab.domain.item;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Game extends Item {

    private String publisher;
    private int minimumAge;
    private Genre genre;

    public Game() { }

    public Game(Long id, String title, double price, String supplierId,
                String publisher, int minimumAge, Genre genre) {
        super(id, title, price, supplierId);
        this.publisher = publisher;
        this.minimumAge = minimumAge;
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Genre getGenre() {
        return genre;
    }

    @Enumerated(EnumType.ORDINAL)
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public enum Genre {
        MMORPG, RPG, FPS, RTS, RACE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return minimumAge == game.minimumAge &&
                Objects.equals(publisher, game.publisher) &&
                genre == game.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher, minimumAge, genre);
    }
}
