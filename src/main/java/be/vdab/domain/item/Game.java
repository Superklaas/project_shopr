package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("GAME")
@AttributeOverride(column = @Column(name = "title", length = 100, nullable = false), name = "gameTitle")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"publisher", "title"}))
public class Game extends Item {

    @NotBlank
    @Size(max = 100)
    private String gameTitle;

    @NotBlank
    @Size(max = 100)
    private String publisher;

    @NotNull
    private int minimumAge;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Game(String gameTitle, double price, String supplierId, int inventory, String publisher) {
        super(gameTitle, price, supplierId, inventory);
        this.publisher = publisher;
    }

    public Game() {}

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String title) {
        this.gameTitle = title;
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
