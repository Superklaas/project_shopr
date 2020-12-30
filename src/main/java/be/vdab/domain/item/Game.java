package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@DiscriminatorValue("GAME")
public class Game extends Item {

    @NotBlank
    @Size(max = 100)
    private String publisher;

    private int minimumAge;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    public Game(String title, double price, String supplierId, int inventory, String publisher) {
        super(title, price, supplierId, inventory);
        this.publisher = publisher;
    }

    public Game() {

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

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public enum Genre {
        MMORPG, RPG, FPS, RTS, RACE
    }

}
