package be.vdab.domain.item.fiction;

import be.vdab.domain.item.Book;

public class Fiction extends Book {

    private Genre genre;
    private String summary;

    public Genre getGenre() {
        return genre;
    }

    public Fiction setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Fiction setSummary(String summary) {
        this.summary = summary;
        return this;
    }

}
