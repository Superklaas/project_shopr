package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    default void createGame(Game game) {
        save(game);
    }

    @Query("select g from Game g order by g.title, g.publisher, g.price asc")
    List<Book> getAllGames();

    Game getGameById(long id);

    Game getGameByTitle(String title);

    default void updateGame(Game game) {
        save(game);
    }

    default void deleteGame(Game game) {
        delete(game);
    }

}
