package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    @Query("select i from Item i order by i.article_type, i.title, i.price asc")
    List<Item> getAllItems();


    Item getItemByTitle(String title);

}
