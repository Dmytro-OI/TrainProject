package Command;

import models.PassengerTrain;
import models.Wagon;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddWagonMenuTest {

    @Test
    void testAddWagon() {
        List<PassengerTrain> trains = new ArrayList<>();
        PassengerTrain train = new PassengerTrain(1001);
        trains.add(train);

        AddWagonMenu addWagonMenu = new AddWagonMenu(trains);


        String input = "1001\n30\n50\n4\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        addWagonMenu.execute();

        assertEquals(1, train.getWagons().size());
        Wagon addedWagon = train.getWagons().get(0);
        assertEquals(30, addedWagon.getPassengerCount());
        assertEquals(50, addedWagon.getBaggageCount());
        assertEquals(4, addedWagon.getComfortLevel());

        input = "9999\n30\n50\n4\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        addWagonMenu.execute();

        assertEquals(1, train.getWagons().size());
    }
}
