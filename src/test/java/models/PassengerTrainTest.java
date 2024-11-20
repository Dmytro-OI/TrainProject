package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class PassengerTrainTest {

    @Test
    void testAddWagon() {
        PassengerTrain train = new PassengerTrain(1001);
        Wagon wagon = new Wagon(50, 10, 3);
        train.addWagon(wagon);

        List<Wagon> wagons = train.getWagons();
        assertEquals(1, wagons.size());
        assertEquals(wagon, wagons.get(0));
    }

    @Test
    void testTrainNumber() {
        PassengerTrain train = new PassengerTrain(1001);
        assertEquals(1001, train.getTrainNumber());
    }

    @Test
    void testToString() {
        PassengerTrain train = new PassengerTrain(1001);
        Wagon wagon = new Wagon(50, 10, 3);
        train.addWagon(wagon);

        String expected = "PassengerTrain{trainNumber=1001, wagons=[Wagon{passengerCount=50, baggageCount=10, comfortLevel=3}]}";
        assertEquals(expected, train.toString());
    }
}
