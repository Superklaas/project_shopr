package be.vdab;

import be.vdab.domain.item.Item;
import be.vdab.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.NonUniqueResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ShoprApplication.class)
public class ItemRepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void getItemByTitle_TitlePresentInDatabase_OtherAttributesAsExpected() {
        List<Item> items = itemRepository.getItemByTitle("A promised land");
        Item item = items.get(0);
        assertEquals(item.getId(), 1);
        assertEquals(item.getItemType(), "NON_FICTION");
        assertEquals(item.getInventory(), 20);
        assertEquals(item.getPrice(), 45);
        assertEquals(item.getSupplierId(), "Pelckmans");
    }

    @Test
    void getItemByTitle_TitleNotPresentInDatabase_IndexOutOfBoundsException() {
        List<Item> items = itemRepository.getItemByTitle("A promised but unreachable land");
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> items.get(0)
        );
    }

    @Test
    void getAllItems_ResultListHasCorrectSize() {
        List<Item> items = itemRepository.getAllItems();
        assertEquals(6, items.size());
    }

    @Test
    void getAllItems_ResultListOrderedByItemType() {
        List<Item> items = itemRepository.getAllItems();
        assertEquals("fiction".toUpperCase(), items.get(0).getItemType());
        assertEquals("game".toUpperCase(), items.get(1).getItemType());
        assertEquals("lp".toUpperCase(), items.get(2).getItemType());
        assertEquals("non_fiction".toUpperCase(), items.get(3).getItemType());
    }

    @Test
    void getAllItems_ResultListOrderedByTitle() {
        List<Item> items = itemRepository.getAllItems();
        assertEquals("A promised land", items.get(3).getTitle());
        assertEquals("B promised land", items.get(4).getTitle());
        //TRAINER TODO: findFirst returns een optional wat ook een object is maar niet het object dat je zoekt.
        //TRAINER TODO: Enkel nog .get()  achter plaatsen dan krijg je een Item object terug
        //TRAINER TODO: en .equals gebruiken voor strings te vergelijken!
        int indexA = items.indexOf(items.stream().filter(item -> item.getTitle().equals("A promised land")).findFirst().get());
        int indexB = items.indexOf(items.stream().filter(item -> item.getTitle().equals("B promised land")).findFirst().get());
        assertTrue(indexA < indexB);
    }

    @Test
    void getAllItems_ResultListOrderedByPrice() {
        List<Item> items = itemRepository.getAllItems();
        assertEquals(45, items.get(4).getPrice());
        assertEquals(75, items.get(5).getPrice());
    }

}
