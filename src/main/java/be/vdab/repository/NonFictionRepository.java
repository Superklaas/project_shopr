package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.book_type.Fiction;
import be.vdab.domain.item.book_type.NonFiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NonFictionRepository extends JpaRepository<NonFiction, Long> {

    @Query("select b from NonFiction b order by b.bookTitle, b.author, b.price asc")
    List<NonFiction> getAllNonFictions();

    List<NonFiction> getNonFictionByTitle(String title);

    List<NonFiction> getNonFictionByPrice(double price);

}
