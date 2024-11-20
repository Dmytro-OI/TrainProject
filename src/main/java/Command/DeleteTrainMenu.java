package Command;

import java.util.List;
import java.util.Scanner;
import models.PassengerTrain;

public class DeleteTrainMenu implements Command {
    private List<PassengerTrain> trains;

    public DeleteTrainMenu(List<PassengerTrain> trains) {
        this.trains = trains;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер потяга, який хочете видалити: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        PassengerTrain trainToDelete = findTrainByNumber(trainNumber);
        if (trainToDelete != null) {
            trains.remove(trainToDelete);
            System.out.println("Потяг з номером " + trainNumber + " видалено.");
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
