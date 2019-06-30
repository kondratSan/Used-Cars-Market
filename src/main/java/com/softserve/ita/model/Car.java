package com.softserve.ita.model;

import java.io.InputStream;
import java.util.Objects;

public class Car {

    private Integer id;

    private int carYear;

    private double engineVolume;

    private int enginePower;

    private int kilometrage;

    private String category;

    private String model;

    private String brand;

    private String fuel;

    private String transmission;

    private String carDrive;

    private String color;

    private InputStream photo1;

    private InputStream photo2;

    private InputStream photo3;

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCarDrive() {
        return carDrive;
    }

    public void setCarDrive(String carDrive) {
        this.carDrive = carDrive;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public InputStream getPhoto1() {
        return photo1;
    }

    public void setPhoto1(InputStream photo1) {
        this.photo1 = photo1;
    }

    public InputStream getPhoto2() {
        return photo2;
    }

    public void setPhoto2(InputStream photo2) {
        this.photo2 = photo2;
    }

    public InputStream getPhoto3() {
        return photo3;
    }

    public void setPhoto3(InputStream photo3) {
        this.photo3 = photo3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carYear == car.carYear && Double.compare(car.engineVolume, engineVolume) == 0 && kilometrage == car.kilometrage && Objects.equals(id, car.id) && Objects.equals(category, car.category) && Objects.equals(model, car.model) && Objects.equals(brand, car.brand) && Objects.equals(fuel, car.fuel) && Objects.equals(transmission, car.transmission) && Objects.equals(carDrive, car.carDrive) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carYear, engineVolume, kilometrage, category, model, brand, fuel, transmission, carDrive, color);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", carYear=" + carYear + ", model='" + model + '\'' + ", brand='" + brand + '\'' + '}';
    }
}
