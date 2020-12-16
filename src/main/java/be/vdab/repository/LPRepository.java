package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.LP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LPRepository extends JpaRepository<LP,Long> {

    default void createLP(LP lp) {
        save(lp);
    }

    @Query("select l from LP l order by l.title, l.artist, l.price asc")
    List<Book> getAllLPs();

    LP getLPById(long id);

    LP getLPByTitle(String title);

    default void updateLP(LP lp) {
        save(lp);
    }

    default void deleteLP(LP lp) {
        delete(lp);
    }

}
