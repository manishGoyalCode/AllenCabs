package org.example;

public class AllenCabsDemo {

    AllenCabs allenCabs = AllenCabs.getInstance();
    public void test1(){

        String driverName1 = "Sachin";
        String driverName2 = "Ramesh";

        allenCabs.addDriver(driverName1,"1232112345","DL01");
        allenCabs.addDriver(driverName2,"9823675636","DL01");

        String vehicleNumber1 = "KA-01-2222";
        String vehicleNumber2 = "KA-01-2223";

        allenCabs.addVehicle(vehicleNumber1,"Ertiga",VehicleType.PREMIUM);
        allenCabs.addVehicle(vehicleNumber2,"Maruti Suzuki",VehicleType.ECONOMY);

        allenCabs.mapDriverToVehilce(driverName1,vehicleNumber1);
        allenCabs.mapDriverToVehilce(driverName2,vehicleNumber2);


        allenCabs.addTrip(50d,1234,1345,TripType.INTERCITY,TripStatus.COMPLETED,driverName1);
        allenCabs.addTrip(1050d,1234,1345,TripType.OUTSTATION,TripStatus.COMPLETED,driverName1);
        allenCabs.addTrip(50d,1234,1345,TripType.INTERCITY,TripStatus.CANCELLED_CUSTOMER,driverName1);
        allenCabs.addTrip(50d,1234,1345,TripType.OUTSTATION,TripStatus.CANCELLED_DRIVER,driverName2);
        allenCabs.addTrip(70d,1234,1345,TripType.OUTSTATION,TripStatus.COMPLETED,driverName2);

        System.out.println(allenCabs.getTotalBillOfDriver(driverName1));
        System.out.println(allenCabs.getTotalBillOfDriver(driverName2));
    }

    public void test2(){
        String driverName1 = "Manish";
        String driverName2 = "Rishabh";

        allenCabs.addDriver(driverName1,"1232112345","DL01");
        allenCabs.addDriver(driverName2,"9823675636","DL01");

        String vehicleNumber1 = "KA-01-00012";
        String vehicleNumber2 = "KA-01-22233";

        allenCabs.addAllenVehicle(vehicleNumber1,"Ertiga",VehicleType.PREMIUM);
        allenCabs.addVehicle(vehicleNumber2,"Maruti Suzuki",VehicleType.ECONOMY);

        allenCabs.mapDriverToVehilce(driverName1,vehicleNumber1);
        allenCabs.mapDriverToVehilce(driverName1,vehicleNumber2);


        allenCabs.addTrip(50d,1234,1345,TripType.INTERCITY,TripStatus.COMPLETED,driverName1);
        allenCabs.addTrip(1050d,1234,1345,TripType.OUTSTATION,TripStatus.COMPLETED,driverName1);
        allenCabs.addTrip(50d,1234,1345,TripType.INTERCITY,TripStatus.CANCELLED_CUSTOMER,driverName1);
        allenCabs.addTrip(50d,1234,1345,TripType.OUTSTATION,TripStatus.CANCELLED_DRIVER,driverName2);
        allenCabs.addTrip(70d,1234,1345,TripType.OUTSTATION,TripStatus.COMPLETED,driverName2);

        System.out.println(allenCabs.getTotalBillOfDriver(driverName1));
        System.out.println(allenCabs.getTotalBillOfDriver(driverName2));

    }
}
