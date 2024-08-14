package org.example;

import java.time.LocalDateTime;

public class Trip {
    Double distance;
    long startTime;
    long endTime;
    TripType tripType;
    TripStatus tripStatus;
    String driverName;
    VehicleType vehicleType;

    public Trip(Double distance, long startTime, long endTime, TripType tripType, TripStatus tripStatus, String driverName,VehicleType vehicleType) {
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripType = tripType;
        this.tripStatus = tripStatus;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "distance=" + distance +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", tripType=" + tripType +
                ", tripStatus=" + tripStatus +
                ", driverName='" + driverName + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
