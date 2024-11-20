package Command;

import models.PassengerTrain;
import models.Wagon;
import java.io.*;
import java.util.List;

public class LoadTrainsFromFileMenu implements Command {
    private List<PassengerTrain> trains;

    public LoadTrainsFromFileMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        String filePath = "E:/файл/train.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Файл не знайдено!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 4) continue;
                int trainNumber = Integer.parseInt(parts[0]);
                int passengerCount = Integer.parseInt(parts[1]);
                int baggageCount = Integer.parseInt(parts[2]);
                int comfortLevel = Integer.parseInt(parts[3]);

                PassengerTrain train = new PassengerTrain(trainNumber);
                Wagon wagon = new Wagon(passengerCount, baggageCount, comfortLevel);
                train.addWagon(wagon);

                trains.add(train);
            }

            System.out.println("Додані потяги:");
            for (PassengerTrain train : trains) {
                train.displayTrainInfo();
            }

            System.out.println("Потяги були успішно завантажені з файлу.");
        } catch (IOException e) {
            System.out.println("Помилка при читанні з файлу");
        }
    }
}
