package org.example;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class AllenCabs {
    private static volatile AllenCabs instance = null;
    private AllenCabs(){

    }

    public static AllenCabs getInstance() {
        if (instance == null) {
            synchronized (AllenCabs.class) {
                if (instance == null) {
                    instance = new AllenCabs();
                }
            }
        }
        return instance;
    }
    TripService tripService = new TripService();
    VehiceService vehiceService = new VehiceService();
    BillingServie billingServie = new BillingServie();

    public boolean addAllenVehicle(String vehicleNumber, String vehicleName, VehicleType vehicleType) {
        return vehiceService.addVehice(new Vehicle(vehicleNumber, vehicleName, vehicleType,true));
    }

    public boolean addVehicle(String vehicleNumber, String vehicleName, VehicleType vehicleType) {
        return vehiceService.addVehice(new Vehicle(vehicleNumber, vehicleName, vehicleType));
    }

    public boolean addDriver(String driverName, String phoneNumber, String drivingLicence) {
        return vehiceService.addDriver(new Driver(driverName, phoneNumber, drivingLicence));
    }

    public boolean mapDriverToVehilce(String driverName, String vehicleNumber) {
        return vehiceService.mapDriverToVehilce(driverName, vehicleNumber);
    }

    public boolean addTrip(Double distance, long startTime, long endTime, TripType tripType,
                           TripStatus tripStatus, String driverName) {
        if (!vehiceService.isDriverWithVehiclePresent(driverName)) {
            return false;
        }
        Vehicle vehicle = vehiceService.getDriverVehicle(driverName);
        if (endTime <= startTime) {
            System.out.println("EndTime should be greater than start time");
            return false;
        }

        tripService.addTrip(distance, startTime, endTime, tripType, tripStatus, driverName,vehicle.getVehicleType());
        return true;
    }

    public Double getTotalBillOfDriver(String driverName) {
        if (!vehiceService.isDriverWithVehiclePresent(driverName)) {
            return 0d;
        }
        List<Trip> driverTrips = tripService.getTripsOfDriver(driverName);
        return getTripsBill(driverTrips, driverName);
    }

    public double getTripsBill(List<Trip> driverTrips, String driverName) {
        Double totalBill = 0d;
        System.out.println("For Driver: " + driverName);
//        vehiceService.getDriverVehicle()
        // add condition for driver should be present and had a car ;
        for (Trip trip : driverTrips) {
            double tripbill = billingServie.getTripCharge(trip, vehiceService.getDriverVehicle(driverName));
            System.out.println(trip + " Bills is : " + tripbill);
            totalBill += tripbill;
        }
        return totalBill;
    }

    public Double getBillOfDriverInTimeInterval(String driverName, long startTime, long endTime) {
        if (!vehiceService.isDriverWithVehiclePresent(driverName)) {
            return 0d;
        }
        List<Trip> driverTrips = tripService.getTripsOfDriver(driverName);
        List<Trip> intervalTrips = driverTrips.stream()
                .filter(trip -> trip.startTime >= startTime && trip.endTime <= endTime)
                .collect(Collectors.toList());
        return getTripsBill(intervalTrips, driverName);
    }


}
