package be.vdab.repository;

import be.vdab.domain.item.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRespository extends JpaRepository<Book, Long> {

}
