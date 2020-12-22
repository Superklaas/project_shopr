package be.vdab;

import be.vdab.domain.item.Item;
import be.vdab.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ShoprApplication.class)
public class ItemRepositoryTests {

	@Autowired
	ItemRepository itemRepository;

	@Test
	void getItemByTitle() {
		Item item = itemRepository.getItemByTitle("A promised land");
		assertEquals(item.getId(),1);
	}

}
