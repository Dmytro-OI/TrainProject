package Command;

import models.PassengerTrain;
import models.Wagon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveWagonMenuTest {

    private List<PassengerTrain> trains;
    private RemoveWagonMenu removeWagonMenu;

    @BeforeEach
    public void setUp() {
        trains = new ArrayList<>();
        PassengerTrain train = new PassengerTrain(1001);
        trains.add(train);

        // Додаємо кілька вагонів до потяга
        Wagon wagon1 = new Wagon(100, 50, 3);
        Wagon wagon2 = new Wagon(200, 100, 5);
        train.addWagon(wagon1);
        train.addWagon(wagon2);

        removeWagonMenu = new RemoveWagonMenu(trains);
    }

    @Test
    public void testExecute_WhenTrainAndWagonExist_ShouldRemoveWagon() {
        System.setIn(new java.io.ByteArrayInputStream("1001\n100\n50\n3\n".getBytes()));

        removeWagonMenu.execute();

        PassengerTrain train = trains.get(0);
        assertEquals(1, train.getWagons().size());
    }

    @Test
    public void testExecute_WhenTrainNotFound_ShouldPrintError() {
        System.setIn(new java.io.ByteArrayInputStream("9999\n100\n50\n3\n".getBytes()));

        removeWagonMenu.execute();
    }

    @Test
    public void testExecute_WhenWagonNotFound_ShouldPrintError() {
        System.setIn(new java.io.ByteArrayInputStream("1001\n300\n150\n10\n".getBytes()));

        removeWagonMenu.execute();
    }
}
