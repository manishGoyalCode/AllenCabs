package org.example;

public class Driver {
    String name;
    String phoneNumber;
    String drivingLicence;
    Vehicle vehicle;

    public Driver(String name, String phoneNumber, String drivingLicence) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.drivingLicence = drivingLicence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
