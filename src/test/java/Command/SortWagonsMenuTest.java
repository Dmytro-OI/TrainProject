package Command;

import models.PassengerTrain;
import models.Wagon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SortWagonsMenuTest {

    private SortWagonsMenu sortWagonsMenu;
    private PassengerTrain train;

    @BeforeEach
    public void setUp() {
        Wagon wagon1 = new Wagon(50, 30, 5);
        Wagon wagon2 = new Wagon(30, 50, 4);
        Wagon wagon3 = new Wagon(40, 60, 6);

        train = new PassengerTrain(1001);
        train.addWagon(wagon1);
        train.addWagon(wagon2);
        train.addWagon(wagon3);

        sortWagonsMenu = new SortWagonsMenu(Arrays.asList(train));
    }

    @Test
    public void testSortWagonsByComfort() {
        assertEquals(5, train.getWagons().get(0).getComfortLevel());
        assertEquals(4, train.getWagons().get(1).getComfortLevel());
        assertEquals(6, train.getWagons().get(2).getComfortLevel());

        String simulatedInput = "1001\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        sortWagonsMenu.execute();

        assertEquals(4, train.getWagons().get(0).getComfortLevel());
        assertEquals(5, train.getWagons().get(1).getComfortLevel());
        assertEquals(6, train.getWagons().get(2).getComfortLevel());
    }

    @Test
    public void testFindTrainByNumber() {
        PassengerTrain foundTrain = sortWagonsMenu.findTrainByNumber(1001);
        assertNotNull(foundTrain);
        assertEquals(1001, foundTrain.getTrainNumber());
    }
}
