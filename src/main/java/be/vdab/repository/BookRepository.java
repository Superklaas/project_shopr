package be.vdab.repository;

import be.vdab.domain.item.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select b from Book b order by b.bookTitle, b.author, b.price asc")
    List<Book> getAllBooks();

    List<Book> getBookByBookType(String bookType);

    List<Book> getBookByTitle(String title);

    List<Book> getBookByPrice(double price);

}
