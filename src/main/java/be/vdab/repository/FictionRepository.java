package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Item;
import be.vdab.domain.item.book_type.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FictionRepository extends JpaRepository<Fiction,Long> {

    default void createFiction(Fiction fiction) {
        save(fiction);
    }

    @Query("select b from Book b where b.book_type = 'FICTION' order by b.title, b.author, b.price asc")
    List<Book> getAllFictions();

    Fiction getFictionById(long id);

    Fiction getFictionByTitle(String title);

    default void updateFiction(Fiction fiction) {
        save(fiction);
    }

    default void deleteFiction(Fiction fiction) {
        delete(fiction);
    }

}
