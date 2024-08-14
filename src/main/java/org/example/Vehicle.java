package org.example;

public class Vehicle {

    String vehicleNumber;
    String vehicleName;
    VehicleType vehicleType;
    Driver driver;
    boolean isAllenOwned;

    public Vehicle(String vehicleNumber, String vehicleName, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.isAllenOwned = false;
    }

    public Vehicle(String vehicleNumber, String vehicleName, VehicleType vehicleType,boolean isAllenOwned) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.isAllenOwned = isAllenOwned;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


}
