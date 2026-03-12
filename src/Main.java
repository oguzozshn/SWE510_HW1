import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();


        while (true) {
            System.out.println("Please enter your brand (press 0 to quit):");
            String userBrand = scanner.nextLine();

            if (userBrand.equals("0")) {
                break;
            }

            System.out.println("Please enter your model:");
            String userModel = scanner.nextLine();

            System.out.println("Choose vehicle type: 1-Car, 2-Bicycle");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                vehicles.add(new Car(userBrand, userModel));
            } else if (choice.equals("2")) {
                vehicles.add(new Bicycle(userBrand, userModel));
            } else {
                System.out.println("Invalid vehicle type.");
            }
        }

        System.out.println("\nAdded vehicles:");
        for (Vehicle vehicle : vehicles) {
            vehicle.ShowInfo();
        }

        scanner.close();
    }

    static abstract class Vehicle {
        private String Brand;
        protected String Model;
        protected int Speed;

        public Vehicle(String brand, String model) {
            this.Brand = brand;
            this.Model = model;
            this.Speed = 0;
        }

        public String getBrand() {
            return Brand;
        }

        public abstract void Run();

        public void SpeedUp() {
            this.Speed += 10;
            System.out.println("Vehicle speed has increased 10 units. New Speed: " + this.Speed);
        }

        public void SpeedUp(int amount) {
            this.Speed += amount;
            System.out.println("Vehicle speed has increased " + amount + " units. New Speed: " + this.Speed);
        }

        public void ShowInfo() {
            System.out.println("Vehicle: " + getBrand() + " " + Model);
        }
    }

    static class Car extends Vehicle {
        public Car(String Brand, String Model) {
            super(Brand, Model);
        }

        public void Run() {
            System.out.println(getBrand() + " " + Model + " engine started.");
        }

        public void ShowInfo() {
            System.out.println("Car: " + getBrand() + " " + Model);
        }
    }

    static class Bicycle extends Vehicle {
        public Bicycle(String Brand, String Model) {
            super(Brand, Model);
        }

        public void Run() {
            System.out.println(getBrand() + " " + Model + " the pedals started turning.");
        }

        public void ShowInfo() {
            System.out.println("Bicycle: " + getBrand() + " " + Model);
        }
    }
}
