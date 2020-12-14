package be.vdab.domain.item.lp;

import be.vdab.domain.item.Item;

public class LP extends Item {

    private String artist;
    private Genre genre;

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

}
