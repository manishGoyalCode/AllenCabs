package org.example;

import java.util.HashMap;
import java.util.List;

public class VehiceService {

    HashMap<String, Driver> driverHashMap;
    HashMap<String, Vehicle> vehicleHashMap;

    HashMap<String, String> driverVehicleMap;

    public VehiceService() {
        driverHashMap = new HashMap<>();
        vehicleHashMap = new HashMap<>();
        driverVehicleMap = new HashMap<>();
    }

    public boolean mapDriverToVehilce(String driverName, String vehicleNumber) {
        Driver driver = getDriver(driverName);
        Vehicle vehicle = getVehicle(vehicleNumber);
        if (driver == null) {
            System.out.println("Driver Not Found");
            return false;
        }
        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return false;
        }
        if (driverVehicleMap.containsKey(driverName)) {
            System.out.println("Driver Already having Vehicle");
        }
        driverVehicleMap.put(driverName, vehicleNumber);
        driver.setVehicle(vehicle);
        vehicle.setDriver(driver);
        return true;
    }

    public boolean removeVehicleFromDriver(String driverName) {
        driverVehicleMap.remove(driverName);
        Driver driver = getDriver(driverName);
        if (driver == null) {
            System.out.println("Driver Not Found");
            return false;
        }
        driver.setVehicle(null);
        return true;
    }


    public boolean addDriver(Driver driver) {
        if (driverHashMap.containsKey(driver.getName())) {
            System.out.println("Driver Already Present");
            return false;
        }
        driverHashMap.put(driver.getName(), driver);
        System.out.println(driver.getName() + " Driver addition Done");
        return true;
    }




    public boolean addVehice(Vehicle vehicle) {
        if (vehicleHashMap.containsKey(vehicle.getVehicleNumber())) {
            System.out.println("Vehice Number Already Present");
            return false;
        }
        vehicleHashMap.put(vehicle.getVehicleNumber(), vehicle);
        System.out.println(vehicle.getVehicleNumber() + " Vehicle addition Done");
        return true;
    }

    public Driver getDriver(String driverName) {
        return driverHashMap.get(driverName);
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleHashMap.get(vehicleNumber);
    }


    public boolean isDriverWithVehiclePresent(String driverName){
        if(!driverVehicleMap.containsKey(driverName))
            System.out.println(driverName + " Driver with vehicle not present");
        return driverVehicleMap.containsKey(driverName);
    }
    public boolean isDriverPresent(String driverName) {
        if(!driverHashMap.containsKey(driverName))
            System.out.println(driverName + " Driver not present");
        return driverHashMap.containsKey(driverName);
    }

    public Vehicle getDriverVehicle(String driverName){
        return driverHashMap.get(driverName).getVehicle();
    }
}
