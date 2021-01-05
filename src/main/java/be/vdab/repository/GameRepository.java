package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    @Query("select g from Game g order by g.gameTitle, g.publisher, g.price asc")
    List<Game> getAllGames();

    List<Game> getGameByTitle(String title);

    List<Game> getGameByPrice(double price);

}
