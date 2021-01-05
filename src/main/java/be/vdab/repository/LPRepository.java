package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.LP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LPRepository extends JpaRepository<LP,Long> {

    @Query("select l from LP l order by l.lpTitle, l.artist, l.price asc")
    List<Book> getAllLPs();

    List<LP> getLPByTitle(String title);

    List<LP> getLPByPrice(double price);

}
