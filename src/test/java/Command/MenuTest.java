package Command;

import models.PassengerTrain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {

    private List<PassengerTrain> trains;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        trains = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testShowMenu_InvalidOption() {
        String input = "99\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Menu menu = new Menu(trains);
        menu.showMenu();

        String output = outputStream.toString();
        assertTrue(output.contains("Такого варіанту відповіді НЕ існує"));
    }

    @Test
    void testShowMenu_ExitOption() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Menu menu = new Menu(trains);
        menu.showMenu();

        String output = outputStream.toString();
        assertTrue(output.contains("Вихід з програми"));
    }
}