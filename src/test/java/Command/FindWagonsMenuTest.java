package Command;

import models.PassengerTrain;
import models.Wagon;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindWagonsMenuTest {

    @Test
    void testFindWagons() {
        List<PassengerTrain> trains = new ArrayList<>();
        PassengerTrain train1 = new PassengerTrain(1001); // Потяг з номером 1001
        PassengerTrain train2 = new PassengerTrain(1002); // Потяг з номером 1002

        train1.addWagon(new Wagon(30, 50, 4)); // Вагон з 30 пасажирами
        train1.addWagon(new Wagon(10, 20, 3)); // Вагон з 10 пасажирами
        train2.addWagon(new Wagon(40, 60, 5)); // Вагон з 40 пасажирами

        trains.add(train1);
        trains.add(train2);

        FindWagonsMenu findWagonsMenu = new FindWagonsMenu(trains);

        String input = "1001\n15\n35\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        findWagonsMenu.execute();
    }

    @Test
    void testTrainNotFound() {

        List<PassengerTrain> trains = new ArrayList<>();
        PassengerTrain train1 = new PassengerTrain(1001); // Потяг з номером 1001
        trains.add(train1);

        FindWagonsMenu findWagonsMenu = new FindWagonsMenu(trains);

        String input = "9999\n10\n30\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        findWagonsMenu.execute();
    }
}
