package be.vdab.domain.item.book_type;

import be.vdab.domain.item.Book;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("NON_FICTION")
public class NonFiction extends Book {

    @Enumerated(EnumType.ORDINAL)
    private Subject subject;

    public NonFiction(String title, double price, String supplierId, int inventory, String isbn) {
        super(title, price, supplierId, inventory, isbn);
    }

    public NonFiction() {

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) { this.subject = subject;}

    public enum Subject {
        HISTORY, COOKBOOK, SCIENCE, SPORT
    }

}
