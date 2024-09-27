package SelfAssessment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Car {
    int id;
    String make;
    String model;
    int yearOfManufacture;
    String color;
    double price;
    String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return id + ", " + make + ", " + model + ", " + yearOfManufacture + ", " + color + ", " + price + ", " + registrationNumber;
    }
}


public class CarManager {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 2015, "Red", 15000, "ABC123"));
        cars.add(new Car(2, "Honda", "Civic", 2018, "Blue", 18000, "XYZ789"));
        cars.add(new Car(3, "Ford", "Mustang", 2012, "Black", 25000, "LMN456"));
        cars.add(new Car(4, "Toyota", "Corolla", 2020, "White", 20000, "DEF456"));
        cars.add(new Car(5, "Honda", "Accord", 2010, "Gray", 12000, "GHI789"));

        saveCarsByBrand(cars, "Toyota");
        saveCarsByModelAndYears(cars, "Civic", 5);
        saveCarsByYearAndPrice(cars, 2015, 14000);
    }

    // Save cars of a given brand
    public static void saveCarsByBrand(List<Car> cars, String brand) {
        try (PrintWriter writer = new PrintWriter(new File("cars_by_brand.txt"))) {
            for (Car car : cars) {
                if (car.make.equalsIgnoreCase(brand)) {
                    writer.println(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save cars of a given model that have been in use for more than n years
    public static void saveCarsByModelAndYears(List<Car> cars, String model, int years) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        try (PrintWriter writer = new PrintWriter(new File("cars_by_model_and_years.txt"))) {
            for (Car car : cars) {
                if (car.model.equalsIgnoreCase(model) && (currentYear - car.yearOfManufacture) > years) {
                    writer.println(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save cars of a given year of manufacture with price higher than specified
    public static void saveCarsByYearAndPrice(List<Car> cars, int year, double price) {
        try (PrintWriter writer = new PrintWriter(new File("cars_by_year_and_price.txt"))) {
            for (Car car : cars) {
                if (car.yearOfManufacture == year && car.price > price) {
                    writer.println(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

