package org.example;
import java.util.Scanner;

class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}

class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) throws InvalidYearException {
        if (year > getCurrentYear()) {
            throw new InvalidYearException("Invalid year: " + year + ". Tahun tidak boleh lebih dari tahun sekarang.");
        }
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String vehicleSound() {
        return "Generic vehicle sound";
    }

    private int getCurrentYear() {
        return 2024;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

class Car extends Vehicle {
    private int numOfDoors;

    public Car(String brand, String model, int year, int numOfDoors) throws InvalidYearException {
        super(brand, model, year);
        this.numOfDoors = numOfDoors;
    }

    @Override
    public String vehicleSound() {
        return "Broom Broom!";
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) throws InvalidYearException {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String vehicleSound() {
        return hasSidecar ? "Vroom with a sidecar!" : "Ngengggggg!";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Choose vehicle type:");
                System.out.println("1. Car");
                System.out.println("2. Motorcycle");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();
                if (choice == 1) {
                    createCar(scanner);
                } else if (choice == 2) {
                    createMotorcycle(scanner);
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InvalidYearException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Vehicle creation process completed.");
            scanner.close();
        }
    }

    public static void printVehicleSound(Vehicle vehicle) {
        System.out.println(vehicle.vehicleSound());
    }

    public static void createCar(Scanner scanner) throws InvalidYearException {
        String brand = "Toyota";
        String model = "Yaris";

        System.out.println("Enter car details:");
        System.out.println("Brand:" + brand);
        System.out.println("Model: "+ model);
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Number of doors: ");
        int numOfDoors = scanner.nextInt();

        Vehicle car = new Car(brand, model, year, numOfDoors);
        System.out.println("Car sound: " + car.vehicleSound());
    }

    public static void createMotorcycle(Scanner scanner) throws InvalidYearException {
        String brand = "Honda";
        String model = "Mio";

        System.out.println("Enter motorcycle details:");
        System.out.println("Brand:" + brand);
        System.out.println("Model: "+ model);
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Has sidecar (true/false): ");
        boolean hasSidecar = scanner.nextBoolean();

        Vehicle motorcycle = new Motorcycle(brand, model, year, hasSidecar);
        System.out.println("Motorcycle sound: " + motorcycle.vehicleSound());
    }
}