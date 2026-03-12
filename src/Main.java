import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        boolean programRunning = true;

        while (programRunning) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 - Add Vehicle");
            System.out.println("2 - Speed Up Vehicles");
            System.out.println("3 - Show Vehicle Info");
            System.out.println("0 - Quit");
            System.out.print("Choose: ");
            String mainChoice = scanner.nextLine();

            switch (mainChoice) {
                case "1":
                    while (true) {
                        System.out.println("\n--- ADD VEHICLE MENU ---");
                        System.out.println("1 - Add Car");
                        System.out.println("2 - Add Bicycle");
                        System.out.println("3 - Add Electric Car");
                        System.out.println("0 - Back to Main Menu");
                        System.out.print("Choose: ");
                        String addChoice = scanner.nextLine();

                        if (addChoice.equals("0")) {
                            break;
                        }

                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();

                        if (addChoice.equals("1")) {
                            vehicles.add(new Car(brand, model));
                            System.out.println("Car added successfully.");
                        } else if (addChoice.equals("2")) {
                            vehicles.add(new Bicycle(brand, model));
                            System.out.println("Bicycle added successfully.");
                        } else if (addChoice.equals("3")) {
                            vehicles.add(new ElectricCar(brand, model));
                            System.out.println("Electric Car added successfully.");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "2":
                    while (true) {
                        System.out.println("\n--- SPEED UP MENU ---");
                        if (vehicles.isEmpty()) {
                            System.out.println("No vehicles found.");
                            break;
                        }

                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.print((i + 1) + " - ");
                            vehicles.get(i).ShowInfo();
                        }

                        System.out.println("0 - Back to Main Menu");
                        System.out.print("Choose vehicle number: ");
                        String vehicleChoice = scanner.nextLine();

                        if (vehicleChoice.equals("0")) {
                            break;
                        }

                        int index = Integer.parseInt(vehicleChoice) - 1;

                        if (index >= 0 && index < vehicles.size()) {
                            System.out.print("Enter speed up amount: ");
                            String amount = scanner.nextLine();
                            int amountInt = Integer.parseInt(amount);

                            vehicles.get(index).SpeedUp(amountInt);

                        } else {
                            System.out.println("Invalid vehicle number.");
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.println("\n--- SHOW INFO MENU ---");
                        if (vehicles.isEmpty()) {
                            System.out.println("No vehicles found.");
                        } else {
                            for (int i = 0; i < vehicles.size(); i++) {
                                System.out.print((i + 1) + " - ");
                                vehicles.get(i).ShowInfo();
                            }
                        }

                        System.out.println("0 - Back to Main Menu");
                        System.out.print("Choose 0 to return: ");
                        String backChoice = scanner.nextLine();

                        if (backChoice.equals("0")) {
                            break;
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "0":
                    programRunning = false;
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
    interface I_Autonomous {
        void activateAutoPilot();
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
            System.out.println("No amount has entered - 1Vehicle speed has increased 10 units. New Speed: " + this.Speed);
        }

        public void SpeedUp(int amount) {
            this.Speed += amount;
            System.out.println("Vehicle speed has increased " + amount + " units. New Speed: " + this.Speed);
        }

        public void ShowInfo() {
            System.out.println("Vehicle: " + getBrand() + " " + Model + " | Speed: " + Speed);
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
            System.out.println("Car: " + getBrand() + " " + Model + " | Speed: " + Speed);
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
            System.out.println("Bicycle: " + getBrand() + " " + Model + " | Speed: " + Speed);
        }
    }

    static class ElectricCar extends Vehicle implements I_Autonomous {
        public ElectricCar(String brand, String model) {
            super(brand, model);
        }

        public void Run() {
            System.out.println(getBrand() + " engine started silently.");
        }

        public void activateAutoPilot() {
            System.out.println("AutoPilot has started. You can free your hands from steering wheel.");
        }
    }
}
