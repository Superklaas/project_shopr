package be.vdab.domain.item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@AttributeOverride(column = @Column(name = "title", length = 100, nullable = false), name = "lpTitle")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"artist", "title"})})
@DiscriminatorValue("LP")
public class LP extends Item {

    @NotBlank
    @Size(max = 100)
    private String lpTitle;

    @NotBlank
    @Size(max = 100)
    private String artist;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public LP(String lpTitle, double price, String supplierId, int inventory, String artist) {
        super(lpTitle, price, supplierId, inventory);
        this.artist = artist;
    }

    public LP() {
    }

    public String getLpTitle() {
        return lpTitle;
    }

    public void setLpTitle(String title) {
        this.lpTitle = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public enum Genre {
        CLASSICAL, POP, ROCK, DANCE, RB, HIPHOP
    }

}
