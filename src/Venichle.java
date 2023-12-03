import java.util.Scanner;

// Суперклас
class TransportVehicle {
    protected String brand;
    protected String model;
    protected int year;

    public TransportVehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void Show() {
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("Рік випуску: " + year);
    }
}

// Підклас Автомобіль
class Car extends TransportVehicle {
    private int numberOfDoors;
    private String fuelType;

    public Car(String brand, String model, int year, int numberOfDoors, String fuelType) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Кількість дверей: " + numberOfDoors);
        System.out.println("Тип пального: " + fuelType);
    }
}

// Підклас Поїзд
class Train extends TransportVehicle {
    private int numberOfCars;
    private String trainType;

    public Train(String brand, String model, int year, int numberOfCars, String trainType) {
        super(brand, model, year);
        this.numberOfCars = numberOfCars;
        this.trainType = trainType;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Кількість вагонів: " + numberOfCars);
        System.out.println("Тип поїзда: " + trainType);
    }
}

public class Venichle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість транспортних засобів: ");
        int n = scanner.nextInt();

        TransportVehicle[] vehicles = new TransportVehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Введіть дані для транспортного засобу " + (i + 1));
            System.out.print("Марка: ");
            String brand = scanner.next();
            System.out.print("Модель: ");
            String model = scanner.next();
            System.out.print("Рік випуску: ");
            int year = scanner.nextInt();

            System.out.println("Виберіть тип транспортного засобу (1 - Автомобіль, 2 - Поїзд): ");
            int typeChoice = scanner.nextInt();

            switch (typeChoice) {
                case 1:
                    System.out.print("Кількість дверей: ");
                    int numberOfDoors = scanner.nextInt();
                    System.out.print("Тип пального: ");
                    String fuelType = scanner.next();
                    vehicles[i] = new Car(brand, model, year, numberOfDoors, fuelType);
                    break;
                case 2:
                    System.out.print("Кількість вагонів: ");
                    int numberOfCars = scanner.nextInt();
                    System.out.print("Тип поїзда: ");
                    String trainType = scanner.next();
                    vehicles[i] = new Train(brand, model, year, numberOfCars, trainType);
                    break;
                default:
                    System.out.println("Невірний вибір типу транспортного засобу.");
                    i--;
                    break;
            }
        }

        System.out.println("Інформація про транспортні засоби:");
        for (TransportVehicle vehicle : vehicles) {
            vehicle.Show();
            System.out.println();
            scanner.close();
        }
    }
}
