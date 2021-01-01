package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Item;
import be.vdab.domain.item.book_type.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FictionRepository extends JpaRepository<Fiction,Long> {

    @Query("select b from Book b where b.book_type = 'FICTION' order by b.title, b.author, b.price asc")
    List<Fiction> getAllFictions();

    List<Fiction> getFictionByTitle(String title);

    List<Fiction> getFictionByPrice(double price);

}
