package be.vdab.domain.item.book_type;

import be.vdab.domain.item.Book;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("NON_FICTION")
public class NonFiction extends Book {

    public NonFiction() { }
    public NonFiction(Long id, String title, double price, String supplierId, String author,
                      String isbn, int pages, Subject subject) {
        super(id, title, price, supplierId, author, isbn, pages);
        this.subject = subject;
    }

    private Subject subject;

    @Enumerated(EnumType.ORDINAL)
    public void setSubject(Subject subject) { this.subject = subject;}

    public enum Subject {
        HISTORY, COOKBOOK, SCIENCE, SPORT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonFiction that = (NonFiction) o;
        return subject == that.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
