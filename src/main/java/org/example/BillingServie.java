package org.example;

public class BillingServie {

    double allenCommisionforLease = 0.3;
    private double getPerKMCharge(TripType tripType,VehicleType vehicleType){
        return getPerKMCharge(vehicleType)*getMuliplierByTripType(tripType);
    }

    private double getMuliplierByTripType(TripType tripType){
        if(tripType == TripType.INTERCITY){
            return 1d;
        }
        if(tripType == TripType.OUTSTATION){
            return 2d;
        }
        return 0;
    }

    private double getCancelationCharge(TripType tripType,VehicleType vehicleType){
        return getMuliplierByTripType(tripType)*getCancelationChargeByVehilceType(vehicleType);
    }
    private double getCancelationChargeByVehilceType(VehicleType vehicleType){
        if(vehicleType == VehicleType.LUXURY){
            return 30d;
        }
        if(vehicleType == VehicleType.PREMIUM){
            return 20d;
        }
        if(vehicleType == VehicleType.ECONOMY){
            return 10d;
        }
        System.out.println("Vehicle Type not supported");
        return 15d;
    }

    private double getPerKMCharge(VehicleType vehicleType){
        if(vehicleType == VehicleType.LUXURY){
            return 15d;
        }
        if(vehicleType == VehicleType.PREMIUM){
            return 5d;
        }
        if(vehicleType == VehicleType.ECONOMY){
            return 5d;
        }
        System.out.println("Vehicle Type not supported");
        return 15d;
    }

    private double getCompletedCharge(Trip trip,VehicleType vehicleType,boolean isAllenOwnedVehicle){
        double bill = trip.distance * getPerKMCharge(trip.tripType,vehicleType);
        double allencommision = bill* allenCommisionforLease;
        System.out.println("Total Bill:" +bill+" - Allen Commision: "+ allencommision+" -Driver bill:"+ bill+" -perKm charge:"+getPerKMCharge(trip.tripType,vehicleType));
        if(isAllenOwnedVehicle){
         //   System.out.println("Allen Commision Carged: "+ bill* allenCommisionforLease);
            bill = bill-bill* allenCommisionforLease;
        }

        return bill;
    }

    public Double getTripCharge(Trip trip,Vehicle vehicle) {
        VehicleType vehicleType =vehicle.getVehicleType();

        if(trip.tripStatus == TripStatus.COMPLETED){
            return getCompletedCharge(trip,vehicleType,vehicle.isAllenOwned);
        }
        if(trip.tripStatus == TripStatus.CANCELLED_DRIVER){
            return -getCancelationCharge(trip.tripType,vehicleType);
        }
        if(trip.tripStatus == TripStatus.CANCELLED_CUSTOMER){
            return getCancelationCharge(trip.tripType,vehicleType);
        }
       System.out.println("Trip Status Not supported");
        return 0d;
    }
    //int getPerKmCharge()
}
