package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    default void createItem(Item item) {
        save(item);
    }

    @Query("select b from Book b order by b.title, b.author, b.price asc")
    List<Book> getAllBooks();

    @Query("select b from Fiction b order by b.title, b.author, b.price asc")
    List<Book> getAllFictions();

    @Query("select b from NonFiction b order by b.title, b.author, b.price asc")
    List<Book> getAllNonFictions();

    @Query("select g from Game g order by g.title, g.publisher, g.price asc")
    List<Book> getAllGames();

    @Query("select l from LP l order by l.title, l.artist, l.price asc")
    List<Book> getAllLPs();

    default void updateItem(Item item) {
        save(item);
    }

    default void deleteItem(Item item) {
        delete(item);
    }

}
