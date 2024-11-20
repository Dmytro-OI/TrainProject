package Command;

import models.PassengerTrain;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map<Integer, Command> commands;
    private List<PassengerTrain> trains;

    public Menu(List<PassengerTrain> trains) {
        this.trains = trains;
        commands = new HashMap<>();

        commands.put(1, new AddTrainMenu(trains));
        commands.put(2, new AddWagonMenu(trains));
        commands.put(3, new RemoveWagonMenu(trains));
        commands.put(4, new DeleteTrainMenu(trains));
        commands.put(5, new SaveTrainsToFileMenu(trains));
        commands.put(6, new LoadTrainsFromFileMenu(trains));
        commands.put(7, new CalculateTotalPassengersMenu(trains));
        commands.put(8, new SortWagonsMenu(trains));
        commands.put(9, new FindWagonsMenu(trains));
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("Головне меню:");
            System.out.println("1. Додати потяг");
            System.out.println("2. Додати вагон");
            System.out.println("3. Видалити вагон");
            System.out.println("4. Видалити потяг");
            System.out.println("5. Зберегти потяги у файл");
            System.out.println("6. Завантажити потяги з файлу");
            System.out.println("7. Порахувати загальну кількість пасажирів");
            System.out.println("8. Сортувати вагони за рівнем комфорту");
            System.out.println("9. Знайти вагони за кількістю пасажирів");
            System.out.println("0. Вихід");
            System.out.print("Виберіть пункт меню: ");
            choice = Integer.parseInt(scanner.nextLine());

            if (commands.containsKey(choice)) {
                commands.get(choice).execute();
            } else if (choice != 0) {
                System.out.println("Такого варіанту відповіді НЕ існує");
            }
        }

        System.out.println("Вихід з програми");
    }
}
