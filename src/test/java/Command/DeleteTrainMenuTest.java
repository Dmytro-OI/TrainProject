package Command;

import models.PassengerTrain;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTrainMenuTest {

    @Test
    void testDeleteTrain() {
        List<PassengerTrain> trains = new ArrayList<>();
        PassengerTrain train1 = new PassengerTrain(1001);
        PassengerTrain train2 = new PassengerTrain(1002);
        trains.add(train1);
        trains.add(train2);

        DeleteTrainMenu deleteTrainMenu = new DeleteTrainMenu(trains);

        System.setIn(new java.io.ByteArrayInputStream("1001\n".getBytes()));
        deleteTrainMenu.execute();

        assertEquals(1, trains.size());
        assertFalse(trains.contains(train1));

        System.setIn(new java.io.ByteArrayInputStream("9999\n".getBytes()));
        deleteTrainMenu.execute();

        assertEquals(1, trains.size());
    }
}
