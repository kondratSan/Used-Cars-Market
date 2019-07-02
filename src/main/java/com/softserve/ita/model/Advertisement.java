package com.softserve.ita.model;

import java.util.Objects;

public class Advertisement {

    private Integer id;

    private Integer user_id;

    private Integer car_id;

    private String title;

    private int price;

    private String description;

    private Car car;

    private User user;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return price == that.price && Objects.equals(id, that.id) && Objects.equals(user_id, that.user_id) && Objects.equals(car_id, that.car_id) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, car_id, title, price, description);
    }

    @Override
    public String toString() {
        return "Advertisement{" + "id=" + id + ", user_id=" + user_id + ", car_id=" + car_id + ", title='" + title + '\'' + ", price=" + price + ", description='" + description + '\'' + '}';
    }
}
