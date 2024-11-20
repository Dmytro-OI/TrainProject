package Command;

import java.util.List;
import java.util.Scanner;
import models.PassengerTrain;

class CalculateTotalPassengersMenu implements Command {
    private List<PassengerTrain> trains;

    public CalculateTotalPassengersMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга для підрахунку пасажирів: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        PassengerTrain train = findTrainByNumber(trainNumber);
        if (train != null) {
            int totalPassengers = train.calculateTotalPassengers();
            System.out.println("Загальна кількість пасажирів у потязі з номером " + trainNumber + ": " + totalPassengers);
        } else {
            System.out.println("Потяг з номером " + trainNumber + " не знайдено.");
        }
    }

    private PassengerTrain findTrainByNumber(int trainNumber) {
        for (PassengerTrain train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }
}
