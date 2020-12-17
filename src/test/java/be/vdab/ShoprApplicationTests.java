package be.vdab;

import be.vdab.domain.item.Book;
import be.vdab.domain.item.book_type.Fiction;
import be.vdab.repository.ItemRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class ShoprApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        //INSERT INTO `fiction` VALUES (0,'Slechterik biedt 1 Miljoen euro voor moord meisje',5),(1,'Harry Potter en zijn professor van de duistere kunsten is altijd het plot ',6),(1,'De witcher die door dimensies reist met Ciri mbv de lady of the lake ',10);
        //INSERT INTO `book` VALUES ('Paulo Coelho','978-1-56619-125-4',100,5),('J.K. Rowling','879-1-56619-909-4',100,6),('Pool','666-1-56619-101-4',100,10);
//TRAINER: ipv de scripts om u database op te vullen kan het ook via een JUnit test
//        Fiction book = new Fiction();
//        book.setIsbn("978-1-56619-125-4");
//        book.setPages(100);
//        book.setAuthor("Paulo Coelho");
//        book.setGenre(Fiction.Genre.THRILLER);
//        book.setSummary("Slechterik biedt 1 Miljoen euro voor moord meisje");
//        book.setId(5L); // TRAINER: id van Fiction is is ook de FK naar Item id en Book id
//        Fiction book2 = new Fiction();
//        book2.setIsbn("879-1-56619-909-4");
//        book2.setPages(100);
//        book2.setAuthor("J.K. Rowling");
//        book2.setGenre(Fiction.Genre.FANTASY);
//        book2.setSummary("Harry Potter en zijn professor van de duistere kunsten is altijd het plot");
//        book2.setId(6L);
//        Fiction book3 = new Fiction();
//        book3.setIsbn("666-1-56619-101-4");
//        book3.setPages(100);
//        book3.setAuthor("Pool");
//        book3.setGenre(Fiction.Genre.THRILLER);
//        book3.setSummary("De witcher die door dimensies reist met Ciri mbv de lady of the lake ");
//        book3.setId(10L);
//        itemRepository.saveAll(Arrays.asList(book, book2, book3));
    }

    @Test
    void getAllarticles() {
        Assertions.assertFalse(itemRepository.getAllBooks().isEmpty());
    }

}
