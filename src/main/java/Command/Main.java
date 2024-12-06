package Command;

import java.util.ArrayList;
import java.util.List;

import models.PassengerTrain;

public class Main {
    public static void main(String[] args) {
        List<PassengerTrain> trains = new ArrayList<>();

        Menu menu = new Menu(trains);
        menu.showMenu();
    }
}
