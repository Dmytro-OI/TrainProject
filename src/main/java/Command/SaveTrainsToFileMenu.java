package Command;

import models.PassengerTrain;
import models.Wagon;

import java.io.*;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class SaveTrainsToFileMenu implements Command {

    private List<PassengerTrain> trains;

    public SaveTrainsToFileMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        String filePath = "E:/файл/train.txt";

        Set<Integer> existingTrainNumbers = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int trainNumber = Integer.parseInt(data[0]);
                existingTrainNumbers.add(trainNumber);
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (PassengerTrain train : trains) {
                if (!existingTrainNumbers.contains(train.getTrainNumber())) {
                    for (Wagon wagon : train.getWagons()) {
                        writer.write(train.getTrainNumber() + "," +
                                wagon.getPassengerCount() + "," +
                                wagon.getBaggageCount() + "," +
                                wagon.getComfortLevel());
                        writer.newLine();
                    }
                    System.out.println("Потяг з номером " + train.getTrainNumber() + " додано в файл.");
                } else {
                    System.out.println("Потяг з номером " + train.getTrainNumber() + " вже існує в файлі.");
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних у файл: " + e.getMessage());
        }
    }
}
