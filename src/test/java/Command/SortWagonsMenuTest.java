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
        Wagon wagon1 = new Wagon(50, 30, 5);  // comfortLevel = 5
        Wagon wagon2 = new Wagon(30, 50, 4);  // comfortLevel = 4
        Wagon wagon3 = new Wagon(40, 60, 6);  // comfortLevel = 6

        train = new PassengerTrain(1001);
        train.addWagon(wagon1);
        train.addWagon(wagon2);
        train.addWagon(wagon3);

        sortWagonsMenu = new SortWagonsMenu(Arrays.asList(train));
    }

    @Test
    public void testSortWagonsByComfort() {
        assertEquals(5, train.getWagons().get(0).getComfortLevel(), "Перше значення комфорту має бути 5.");
        assertEquals(4, train.getWagons().get(1).getComfortLevel(), "Друге значення комфорту має бути 4.");
        assertEquals(6, train.getWagons().get(2).getComfortLevel(), "Третє значення комфорту має бути 6.");

        String simulatedInput = "1001\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        sortWagonsMenu.execute();

        assertEquals(4, train.getWagons().get(0).getComfortLevel(), "Перше значення комфорту має бути 6.");
        assertEquals(5, train.getWagons().get(1).getComfortLevel(), "Друге значення комфорту має бути 5.");
        assertEquals(6, train.getWagons().get(2).getComfortLevel(), "Третє значення комфорту має бути 4.");
    }

    @Test
    public void testFindTrainByNumber() {
        PassengerTrain foundTrain = sortWagonsMenu.findTrainByNumber(1001);
        assertNotNull(foundTrain, "Потяг з номером 1001 має бути знайдений.");
        assertEquals(1001, foundTrain.getTrainNumber(), "Номер потяга має бути 1001.");
    }
}
