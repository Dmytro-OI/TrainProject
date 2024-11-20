package Command;

import models.PassengerTrain;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddTrainMenuTest {

    @Test
    void testAddTrain() {
        List<PassengerTrain> trains = new ArrayList<>();
        AddTrainMenu addTrainMenu = new AddTrainMenu(trains);

        InputStream originalIn = System.in;

        try {
            // Емуляція вводу користувача
            String simulatedInput = "1002\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            addTrainMenu.execute();

            assertEquals(1, trains.size(), "Розмір списку потягів має бути 1.");
            assertEquals(1002, trains.get(0).getTrainNumber(), "Номер потяга має бути 1002.");
        } finally {
            System.setIn(originalIn);
        }
    }
}
