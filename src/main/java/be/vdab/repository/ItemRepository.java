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

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("select i from Item i order by i.itemType, i.title, i.price asc")
    List<Item> getAllItems();

    List<Item> getItemByItemType(String itemType);

    List<Item> getItemByTitle(String title);

    List<Item> getItemByPrice(double price);

}


/*

// BOOK

    @Query("select b from Book b order by b.title, b.author, b.price asc")
    List<Book> getAllBooks();

    @Query("select b from Book b where b.id=?1")
    Book getBookById(int id);

    @Query("select b from Book b where b.bookType=?1")
    List<Book> getBookByBookType(String bookType);

    @Query("select b from Book b where b.title=?1")
    List<Book> getBookByTitle(String title);

    @Query("select b from Book b where b.price=?1")
    List<Book> getBookByPrice(double price);

    // FICTION

    @Query("select b from Fiction b order by b.title, b.author, b.price asc")
    List<Fiction> getAllFictions();

    @Query("select b from Fiction b where b.id=?1")
    Fiction getFictionById(int id);

    @Query("select b from Fiction b where b.title=?1")
    List<Fiction> getFictionByTitle(String title);

    @Query("select b from Fiction b where b.price=?1")
    List<Fiction> getFictionByPrice(double price);

    // NON FICTION

    @Query("select b from NonFiction b order by b.title, b.author, b.price asc")
    List<NonFiction> getAllNonFictions();

    // GAME

    @Query("select g from Game g order by g.title, g.publisher, g.price asc")
    List<Game> getAllGames();

    // LP

    @Query("select l from LP l order by l.title, l.artist, l.price asc")
    List<LP> getAllLPs();

*/
