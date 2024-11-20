package Command;

import java.util.List;
import java.util.Scanner;
import models.PassengerTrain;
import models.Wagon;

public class FindWagonsMenu implements Command {
    private List<PassengerTrain> trains;

    public FindWagonsMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга для пошуку вагонів: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        PassengerTrain train = findTrainByNumber(trainNumber);
        if (train != null) {
            System.out.print("Введіть мінімальну кількість пасажирів: ");
            int minPassengers = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть максимальну кількість пасажирів: ");
            int maxPassengers = Integer.parseInt(scanner.nextLine());

            System.out.println("Вагони з кількістю пасажирів від " + minPassengers + " до " + maxPassengers + ":");
            for (Wagon wagon : train.getWagons()) {
                if (wagon.getPassengerCount() >= minPassengers && wagon.getPassengerCount() <= maxPassengers) {
                    wagon.displayInfo();
                }
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
}

