package Command;

import logging.LoggerConfig;
import models.PassengerTrain;
import models.Wagon;

import java.io.*;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class SaveTrainsToFileMenu implements Command {

    private static final Logger logger = LoggerConfig.getLogger();
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
            logger.info("Існуючі потяги успішно завантажено з файлу.");
        } catch (IOException e) {
            logger.warning("Помилка при читанні файлу: " + e.getMessage());
            LoggerConfig.sendCriticalErrorEmail("Помилка читання файлу: " + e.getMessage());
        }

        // Запис нових потягів у файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (PassengerTrain train : trains) {
                if (!existingTrainNumbers.contains(train.getTrainNumber())) {
                    logger.info("Додаємо новий потяг з номером: " + train.getTrainNumber());
                    for (Wagon wagon : train.getWagons()) {
                        writer.write(train.getTrainNumber() + "," +
                                wagon.getPassengerCount() + "," +
                                wagon.getBaggageCount() + "," +
                                wagon.getComfortLevel());
                        writer.newLine();
                        logger.info("Вагон додано до потяга з номером: " + train.getTrainNumber());
                    }
                    existingTrainNumbers.add(train.getTrainNumber());
                } else {
                    logger.info("Потяг з номером " + train.getTrainNumber() + " вже існує. Перевіряємо вагони.");
                    for (Wagon wagon : train.getWagons()) {
                        if (!train.getWagons().contains(wagon)) {
                            writer.write(train.getTrainNumber() + "," +
                                    wagon.getPassengerCount() + "," +
                                    wagon.getBaggageCount() + "," +
                                    wagon.getComfortLevel());
                            writer.newLine();
                            logger.info("Новий вагон додано до потяга з номером: " + train.getTrainNumber());
                        }
                    }
                }
            }
            logger.info("Потяги успішно збережено у файл.");
        } catch (IOException e) {
            logger.severe("Помилка при збереженні даних у файл: " + e.getMessage());
            LoggerConfig.sendCriticalErrorEmail("Помилка збереження у файл: " + e.getMessage());
        }
    }
}
