package be.vdab.domain.item.game;

import be.vdab.domain.item.Item;

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
}
