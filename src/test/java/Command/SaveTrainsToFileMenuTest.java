package Command;

import models.PassengerTrain;
import models.Wagon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class SaveTrainsToFileMenuTest {

    private SaveTrainsToFileMenu saveTrainsToFileMenu;
    private BufferedReader mockedReader;
    private BufferedWriter mockedWriter;
    private List<PassengerTrain> trains;

    @BeforeEach
    public void setUp() {
        mockedReader = mock(BufferedReader.class);
        mockedWriter = mock(BufferedWriter.class);

        Wagon wagon1 = new Wagon(100, 50, 3);
        Wagon wagon2 = new Wagon(120, 60, 4);
        PassengerTrain train1 = new PassengerTrain(123);
        train1.addWagon(wagon1);
        train1.addWagon(wagon2);

        trains = new ArrayList<>();
        trains.add(train1);

        saveTrainsToFileMenu = new SaveTrainsToFileMenu(trains);
    }


    @Test
    public void testExecute_ExistingTrain() throws IOException {
        when(mockedReader.readLine()).thenReturn("123,100,50,3").thenReturn("123,120,60,4").thenReturn(null);  // Потяг з номером 123 вже є в файлі

        saveTrainsToFileMenu.execute();

        verify(mockedWriter, times(0)).write("123,100,50,3");  // Потяг не має бути записаний повторно
        verify(mockedWriter, times(0)).write("123,120,60,4");  // Потяг не має бути записаний повторно
    }
}
