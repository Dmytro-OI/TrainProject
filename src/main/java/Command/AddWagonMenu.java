package Command;

import java.util.List;
import java.util.Scanner;
import models.PassengerTrain;
import models.Wagon;

class AddWagonMenu implements Command {
    private List<PassengerTrain> trains;

    public AddWagonMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        addWagon();
    }

    private void addWagon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга, до якого хочете додати вагон: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        PassengerTrain train = findTrainByNumber(trainNumber);
        if (train != null) {
            System.out.print("Введіть кількість пасажирів: ");
            int passengerCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть кількість багажу: ");
            int baggageCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть рівень комфортності: ");
            int comfortLevel = Integer.parseInt(scanner.nextLine());

            Wagon newWagon = new Wagon(passengerCount, baggageCount, comfortLevel);
            train.addWagon(newWagon);
            System.out.println("Вагон успішно додано до потяга номер " + trainNumber);
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
