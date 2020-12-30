package be.vdab.domain.item;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"artist", "title"})})
@DiscriminatorValue("LP")
public class LP extends Item {

    @NotBlank
    @Size(max = 100)
    private String artist;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    public LP(String title, double price, String supplierId, int inventory, String artist) {
        super(title, price, supplierId, inventory);
        this.artist = artist;
    }

    public LP() {

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
        CLASSICAL, POP, ROCK, DANCE, RB, HIPHOP
    }

}
