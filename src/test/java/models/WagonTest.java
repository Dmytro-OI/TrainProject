package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WagonTest {

    @Test
    void testWagonCreation() {
        Wagon wagon = new Wagon(50, 10, 3);
        assertEquals(50, wagon.getPassengerCount());
        assertEquals(10, wagon.getBaggageCount());
        assertEquals(3, wagon.getComfortLevel());
    }

    @Test
    void testWagonToString() {
        Wagon wagon = new Wagon(50, 10, 3);
        String expected = "Wagon{passengerCount=50, baggageCount=10, comfortLevel=3}";
        assertEquals(expected, wagon.toString());
    }
}
