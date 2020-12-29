package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Game;
import be.vdab.domain.item.Item;
import be.vdab.domain.item.LP;
import be.vdab.domain.item.book_type.Fiction;
import be.vdab.domain.item.book_type.NonFiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    @Query("select i from Item i order by i.itemType, i.title, i.price asc")
    List<Item> getAllItems();

    @Query("select b from Book b order by b.title, b.author, b.price asc")
    List<Book> getAllBooks();

    @Query("select b from Fiction b order by b.title, b.author, b.price asc")
    List<Fiction> getAllFictions();

    @Query("select b from NonFiction b order by b.title, b.author, b.price asc")
    List<NonFiction> getAllNonFictions();

    @Query("select g from Game g order by g.title, g.publisher, g.price asc")
    List<Game> getAllGames();

    @Query("select l from LP l order by l.title, l.artist, l.price asc")
    List<LP> getAllLPs();

    Item getItemByTitle(String title);


}
