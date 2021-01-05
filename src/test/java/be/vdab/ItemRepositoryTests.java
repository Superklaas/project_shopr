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
import java.util.stream.Collectors;

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
        Item itemA = items.stream().filter(item -> item.getTitle().equals("A promised land")).findFirst().get();
        Item itemB = items.stream().filter(item -> item.getTitle().equals("B promised land")).findFirst().get();
        assertTrue(items.indexOf(itemA) < items.indexOf(itemB));
    }

    @Test
    void getAllItems_ResultListOrderedByPrice() {
        List<Item> items = itemRepository.getAllItems();
        List<Item> itemsSameTitle =
                items.stream().filter(item -> item.getTitle().equals("B promised land")).collect(Collectors.toList());
        Item item45 = itemsSameTitle.stream().filter(item -> item.getPrice() == 45).findFirst().get();
        Item item75 = itemsSameTitle.stream().filter(item -> item.getPrice() == 75).findFirst().get();
        assertTrue(items.indexOf(item45) < items.indexOf(item75));
    }

}
