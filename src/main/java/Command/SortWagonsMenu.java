package Command;

import models.PassengerTrain;
import models.Wagon;
import java.util.List;
import java.util.Scanner;

public class SortWagonsMenu implements Command {
    private List<PassengerTrain> trains;

    public SortWagonsMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга для сортування вагонів: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        PassengerTrain train = findTrainByNumber(trainNumber);
        if (train != null) {
            train.sortWagonsByComfort();
            System.out.println("Вагони потяга з номером " + trainNumber + " відсортовано за рівнем комфортності.");
            System.out.println("Відсортовані вагони:");
            for (Wagon wagon : train.getWagons()) {
                wagon.displayInfo();
            }
        } else {
            System.out.println("Потяг з номером " + trainNumber + " не знайдено.");
        }
    }

    protected PassengerTrain findTrainByNumber(int trainNumber) {
        for (PassengerTrain train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }
}