package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("GAME")
//TRAINER TODO: als je uniqueConstraints wil gebruiken op title en ook de title column hebben in Game table kan je AttributeOverride gebruiken om deze van de parent te overiden
@AttributeOverride(column = @Column(name = "title", length = 100, nullable = false), name = "gameTitle")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"publisher", "title"}))
public class Game extends Item {

    @NotBlank
    @Size(max = 100)
    private String publisher;

    private int minimumAge;

    @Size(max = 100)
    private String gameTitle; //TRAINER TODO: gebruik hier best een andere naam voor title (omdat title ook in Item wordt gebruikt), anders krijg je fout meldingen

    @Enumerated(EnumType.ORDINAL) //TRAINER TODO: waarom ordinal en geen string?
    private Genre genre;

    public Game(String gameTitle, double price, String supplierId, int inventory, String publisher) {
        super(gameTitle, price, supplierId, inventory);
        this.publisher = publisher;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String title) {
        this.gameTitle = title;
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
