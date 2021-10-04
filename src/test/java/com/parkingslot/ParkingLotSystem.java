package com.parkingslot;

import java.util.ArrayList;

public class ParkingLotSystem {
    private int actualCapacity;
    //private  int currentCapacity;
    private ArrayList vehicles;
    private ParkingLotOwner owner;
    private AirportSecurity security;

    public ParkingLotSystem(int capacity){
        this.vehicles = new ArrayList<>();
        //this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException{
        if (this.vehicles.size() == this.actualCapacity) {
            owner.capacityIsFull();
            /*Showing sign of full to Airport Security.*/
            security.capacityIsFull();
            throw new ParkingLotException("ParkingLot is full.");
        }
        //this.currentCapacity++;
        if(isVehicleParked(vehicle))
            throw new ParkingLotException("Vehicle already parked.");
        this.vehicles.add(vehicle);
    }

    public boolean unPark(Object vehicle) {
        if (vehicle == null)
            return false;
        if (this.vehicles.contains(vehicle)){
            //this.vehicle = null;
            this.vehicles.remove(vehicle);
            return true;
        }
        return false;
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }

    public void registerSecurity(AirportSecurity airportSecurity) {
        this.security = airportSecurity;
    }
}
