package com.epam.ta.model;

import java.util.Objects;

public class User {
    private String totalPrice;
    private String searchText;
    private String numberOfInstances;
    
    public User(String totalPrice, String searchCalculatorText,String numberOfInstances ) {
        this.totalPrice = totalPrice;
        this.searchText = searchCalculatorText;
        this.numberOfInstances = numberOfInstances;
    }

    public String getTotalPrice() {
        return totalPrice;
    }
    public String getSearchCalculatorText() {
        return searchText;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setTotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setSearchCalculatorText(String searchCalculatorText){
        this.searchText = searchCalculatorText;
    }

    public void setNumberOfInstances(String numberOfInstances){
        this.numberOfInstances = numberOfInstances;
    }

    @Override
    public String toString() {
        return "User{" +
                "total price='" + totalPrice + '\'' +
                ", searched text='" + searchText + '\'' +
                ", number of instances='" + numberOfInstances + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getTotalPrice(), user.getTotalPrice()) &&
                Objects.equals(getSearchCalculatorText(), user.getSearchCalculatorText()) &&
                Objects.equals(getNumberOfInstances(), user.getNumberOfInstances());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTotalPrice(), getSearchCalculatorText(),getNumberOfInstances());
    }
}
