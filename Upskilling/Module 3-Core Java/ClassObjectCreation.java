class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayInfo() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
    }
}
public class ClassObjectCreation {

    public static void main(String[] args) {
      Car car1 = new Car("Toyota", "Camry", 2067);
      Car car2 = new Car("Honda", "Civic", 2035);
      car1.displayInfo();
      car2.displayInfo();
      
    }
}
