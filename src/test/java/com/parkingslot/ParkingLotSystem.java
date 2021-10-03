package com.parkingslot;

public class ParkingLotSystem {
    private final int actualCapacity;
    private  int currentCapacity;
    private Object vehicle;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity){
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void park(Object vehicle) throws ParkingLotException{
        if (this.currentCapacity == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("ParkingLot is full.");
        }
        this.currentCapacity++;
        this.vehicle = vehicle;
    }

    public boolean unPark(Object vehicle) {
        if (vehicle == null)
            return false;
        if (this.vehicle.equals(vehicle)){
            this.vehicle = null;
            return true;
        }
        return false;
    }

    public boolean isVehicleParked(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }
}
