package review.collectionTest02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationManager {
    private Map<String, Integer> cityPopulations = new HashMap<>();

    // Constants for commands
    private static final int ADD_OR_UPDATE = 1;
    private static final int REMOVE = 2;
    private static final int DISPLAY = 3;
    private static final int DISPLAY_ALL = 4;
    private static final int EXIT = 5;

    // Adds or updates the population of the specified city
    public void addOrUpdateCity(String city, int population) {
        cityPopulations.put(city, population);
        System.out.println("도시의 인구를 업데이트 했습니다. " + city + ": " + population);
    }

    // Removes the specified city from the map
    public void removeCity(String city) {
        if (cityPopulations.containsKey(city)) {
            cityPopulations.remove(city);
            System.out.println(city + " 가 없어졌습니다.");
        } else {
            System.out.println("도시를 찾을 수 없습니다.");
        }
    }

    // Displays the population of a specific city
    public void displayPopulation(String city) {
        if (cityPopulations.containsKey(city)) {
            System.out.println(city + "의 인구 수 : " + cityPopulations.get(city));
        } else {
            System.out.println("도시를 찾을 수 없습니다.");
        }
    }

    // Displays all cities and their populations
    public void displayAll() {
        if (cityPopulations.isEmpty()) {
            System.out.println("데이터가 없습니다.");
        } else {
            System.out.println("모든 도시를 불러옵니다. : ");
            cityPopulations.forEach((city, population) -> System.out.println(city + ": " + population));
        }
    }

    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        // Initialize with some data
        manager.addOrUpdateCity("Seoul", 10000000);
        manager.addOrUpdateCity("Busan", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (1: 추가/수정, 2: 삭제, 3: 조회, 4: 전체 조회, 5: 종료): ");
            int command = scanner.nextInt(); // The user enters the command as a number
            scanner.nextLine(); // Consume the newline left-over

            if (command == EXIT) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case ADD_OR_UPDATE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine();
                    System.out.print("도시 인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case REMOVE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine();
                    manager.removeCity(city);
                    break;
                case DISPLAY:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.nextLine();
                    manager.displayPopulation(city);
                    break;
                case DISPLAY_ALL:
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
            }
        }
        scanner.close();
    }
}
