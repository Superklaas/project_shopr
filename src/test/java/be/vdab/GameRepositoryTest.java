package be.vdab;

import be.vdab.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ShoprApplication.class)
public class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Test
    void getGameById() {
        fail();
    }




}
