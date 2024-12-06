package Command;

import java.util.List;
import java.util.Scanner;
import models.PassengerTrain;
import logging.LoggerConfig;
import java.util.logging.Logger;

class AddTrainMenu implements Command {
    private List<PassengerTrain> trains;
    private static final Logger logger = LoggerConfig.getLogger();

    public AddTrainMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());
        PassengerTrain newTrain = new PassengerTrain(trainNumber);
        trains.add(newTrain);
        System.out.println("Потяг з номером " + trainNumber + " додано.");
        logger.info("Потяг з номером " + trainNumber + " додано.");
    }
}

