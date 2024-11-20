package Command;

import java.util.List;
import java.util.Scanner;
import models.PassengerTrain;
import models.Wagon;

public class RemoveWagonMenu implements Command {
    private List<PassengerTrain> trains;

    public RemoveWagonMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер потяга, з якого хочете видалити вагон: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        PassengerTrain train = findTrainByNumber(trainNumber);
        if (train != null) {
            System.out.print("Введіть кількість пасажирів вагона для видалення: ");
            int passengerCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть кількість багажу вагона для видалення: ");
            int baggageCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть рівень комфортності вагона для видалення: ");
            int comfortLevel = Integer.parseInt(scanner.nextLine());

            Wagon wagonToRemove = findWagonToRemove(train, passengerCount, baggageCount, comfortLevel);
            if (wagonToRemove != null) {
                train.removeWagon(wagonToRemove);
                System.out.println("Вагон успішно видалено.");
            } else {
                System.out.println("Вагон з такими параметрами не знайдено.");
            }
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

    private Wagon findWagonToRemove(PassengerTrain train, int passengerCount, int baggageCount, int comfortLevel) {
        for (Wagon wagon : train.getWagons()) {
            if (wagon.getPassengerCount() == passengerCount &&
                    wagon.getBaggageCount() == baggageCount &&
                    wagon.getComfortLevel() == comfortLevel) {
                return wagon;
            }
        }
        return null;
    }
}
