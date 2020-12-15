package be.vdab.domain.item.book_type;

import be.vdab.domain.item.Book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NON_FICTION")
public class NonFiction extends Book {

    private Long id;

    public NonFiction() { }

    private Subject subject;

    public enum Subject {
        HISTORY, COOKBOOK, SCIENCE, SPORT;
    }
}
