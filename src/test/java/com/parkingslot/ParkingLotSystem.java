package com.parkingslot;

import java.util.ArrayList;

public class ParkingLotSystem {
    private int actualCapacity;
    //private  int currentCapacity;
    private ArrayList vehicles;
    private ArrayList<ParkingLotObserver> observers;
    //private AirportSecurity security;
    private ArrayList slots;

    public ParkingLotSystem(int capacity){
        this.slots = new ArrayList();
        this.observers = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        //this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void registerParkingLotObserver(ParkingLotObserver observer) {
        //this.owner = owner;
        this.observers.add(observer);
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    /*public void registerSecurity(AirportSecurity airportSecurity) {
       // this.security = airportSecurity;
    }*/

    public void park(Object vehicle) throws ParkingLotException{
        if (this.vehicles.size() == this.actualCapacity) {
            for (ParkingLotObserver observer:observers) {
                observer.capacityIsFull();
            }
            //owner.capacityIsFull();
            /*Showing sign of full to Airport Security.*/
           // security.capacityIsFull();
            throw new ParkingLotException("ParkingLot is full.");
        }
        //this.currentCapacity++;
        if(findVehicle_IsVehicleParked(vehicle))
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

    /*public boolean isVehicleParked(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }*/

    public void getAvailableSlot(Object slot) {
       this.slots.add(slot);
    }

    /*public boolean findVehicle(Object vehicle) {
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }*/

    //Refactor the code for isVehicleParked() and findVehicle()
    public boolean findVehicle_IsVehicleParked(Object vehicle){
        if (this.vehicles.contains(vehicle))
            return true;
        return false;
    }
}
