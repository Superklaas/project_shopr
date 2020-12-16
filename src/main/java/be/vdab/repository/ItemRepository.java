package be.vdab.repository;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    @Query("select i from Book ")
    List<Item> getAllItems();

}
