package Command;

import models.PassengerTrain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoadTrainsFromFileMenuTest {

    private List<PassengerTrain> trains;
    private LoadTrainsFromFileMenu loadTrainsFromFileMenu;

    @BeforeEach
    void setUp() {
        trains = new ArrayList<>();
        loadTrainsFromFileMenu = new LoadTrainsFromFileMenu(trains);
    }

    @Test
    void testLoadTrainsFromFileSuccessfully() throws IOException {
        File tempFile = new File("train.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.close();

        loadTrainsFromFileMenu.execute();

        assertEquals(2, trains.size());
        assertEquals(1001, trains.get(0).getTrainNumber());
        assertEquals(30, trains.get(0).getWagons().get(0).getPassengerCount());
        assertEquals(1002, trains.get(1).getTrainNumber());
        assertEquals(40, trains.get(1).getWagons().get(0).getPassengerCount());

        boolean fileDeleted = tempFile.delete();
        assertTrue(fileDeleted, "Файл не вдалося видалити після тесту");
    }

    @Test
    void testLoadTrainsFromFileFileNotFound() {
        LoadTrainsFromFileMenu loadTrainsFromFileMenu = new LoadTrainsFromFileMenu(trains);
        String nonExistentFilePath = "non_existent_train.txt";

        File tempFile = new File(nonExistentFilePath);
        assertFalse(tempFile.exists());

        loadTrainsFromFileMenu.execute();
    }
}

