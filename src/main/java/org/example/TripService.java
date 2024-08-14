package org.example;

import java.util.*;

public class TripService {

    HashMap<String, ArrayList<Trip>> driverTrips;
    public TripService() {
        this.driverTrips = new HashMap<>();
    }

    public boolean addTrip(Double distance, long startTime, long endTime, TripType tripType,
                           TripStatus tripStatus, String driverName,VehicleType vehicleType){
        Trip trip = new Trip(distance,startTime,endTime,tripType,tripStatus,driverName,vehicleType);
        // ToDo: check for initisalistion of list;
        if(driverTrips.containsKey(driverName)==false) {
            driverTrips.put(driverName, new ArrayList<>());
        }
        driverTrips.get(driverName).add(trip);

        return true;
    }

    public List<Trip> getTripsOfDriver(String driverName){
        return  driverTrips.get(driverName);
    }


}
