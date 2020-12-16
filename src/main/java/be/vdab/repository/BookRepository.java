package be.vdab.repository;

import be.vdab.domain.item.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select b from Book b order by b.title, b.author, b.price asc")
    List<Book> getAllBooks();

    Book getBookByTitle(String title);

}
