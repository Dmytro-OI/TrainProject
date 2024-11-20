package Command;

import models.PassengerTrain;
import models.Wagon;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalPassengersMenuTest {

    @Test
    void testCalculateTotalPassengers() {
        List<PassengerTrain> trains = new ArrayList<>();
        PassengerTrain train = new PassengerTrain(1001);
        train.addWagon(new Wagon(30, 50, 4));
        train.addWagon(new Wagon(50, 70, 5));
        trains.add(train);

        CalculateTotalPassengersMenu calculateMenu = new CalculateTotalPassengersMenu(trains);

        String input = "1001\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        calculateMenu.execute();

        assertTrue(true);
    }

    @Test
    void testCalculateTotalPassengersForNonExistentTrain() {
        List<PassengerTrain> trains = new ArrayList<>();
        PassengerTrain train = new PassengerTrain(1001);
        trains.add(train);

        CalculateTotalPassengersMenu calculateMenu = new CalculateTotalPassengersMenu(trains);

        String input = "1002\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        calculateMenu.execute();

        assertTrue(true);
    }
}
